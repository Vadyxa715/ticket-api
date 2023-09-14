package com.example.testparttwo.repo.impl;

import com.example.testparttwo.entity.Ticket;
import com.example.testparttwo.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TicketRepoImpl implements TicketRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Ticket ticket) {
        return jdbcTemplate.update("INSERT INTO tickets (departure_time, place, price, paid, user_id, trail_id) VALUES(?,?,?,?,?,?)",
                ticket.getDepartureTime(), ticket.getPlace(), ticket.getPrice(), ticket.getPaid(), ticket.getUserId(), ticket.getTrailId());
    }


    @Override
    public int saveByUserIdAndTrailId(Ticket ticket) {
        return jdbcTemplate.update("INSERT INTO tickets (departure_time, place, price, paid, user_id, trail_id) VALUES(?,?,?,?,?,?)",
                ticket.getDepartureTime(), ticket.getPlace(), ticket.getPrice(), ticket.getPaid(), ticket.getUserId(), ticket.getTrailId());
    }

    @Override
    public int update(Ticket ticket) {
        return jdbcTemplate.update("UPDATE tickets SET departure_time=?, place=?, price=?, paid=? WHERE id=?",
                ticket.getDepartureTime(), ticket.getPlace(), ticket.getPrice(), ticket.getPaid(), ticket.getTicketId());
    }

    @Override
    public int bayTicket(Long ticketId, Long userId) {
        return jdbcTemplate.update("UPDATE tickets SET user_id=?, paid='true' WHERE id=?",
                userId,ticketId);
    }

    @Override
    public Ticket findById(Long id) {
        try {
            Ticket ticket = jdbcTemplate.queryForObject("SELECT * FROM tickets WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Ticket.class), id);
            return ticket;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Ticket> findPaidByUser(Long id) {
        return jdbcTemplate.query("SELECT * FROM tickets WHERE user_id=? and paid",BeanPropertyRowMapper.newInstance(Ticket.class),id);
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM tickets WHERE id=?", id);
    }

    @Override
    public List<Ticket> findAll() {
        return jdbcTemplate.query("SELECT * FROM tickets", BeanPropertyRowMapper.newInstance(Ticket.class));
    }

    @Override
    public List<Ticket> findByPaid(boolean paid) {
        return jdbcTemplate.query("SELECT * FROM tickets WHERE paid=?",
                BeanPropertyRowMapper.newInstance(Ticket.class), paid);
    }

    @Override
    public List<Ticket> findAllByUserPaid(boolean paid, Long id) {
        return jdbcTemplate.query("SELECT * FROM tickets WHERE id=? AND paid=?",
                BeanPropertyRowMapper.newInstance(Ticket.class), id, paid);
    }

    //TO DO WIS ANNA SQL запрос на проверку транспортера
    @Override
    public List<Ticket> findByTransporter(String transporter) {
        return null;
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE FROM ticket");
    }


    public Iterable<Ticket> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Ticket> findAll(Pageable pageable) {
        int page = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        Sort sort = pageable.getSort();

        Sort.Order order = sort.toList().get(0);

        return new PageImpl<>(
                jdbcTemplate.query("SELECT * FROM tickets JOIN trails ON tickets.id = trails.id " +
                                "JOIN transporters ON transporters.id = trails.transporter_id " +
                                "ORDER BY " + order.getProperty() + " " + order.getDirection().name()
                                + " LIMIT " + pageSize + " OFFSET " + page * pageSize,
                        (resultSet, rowNum) ->  mapTicketResult(resultSet)
                )
        );
    }

    private Ticket mapTicketResult(final ResultSet resultSet) throws SQLException {
        Ticket ticket = new Ticket();

        ticket.setTicketId(resultSet.getLong("id"));
        ticket.setDepartureTime(resultSet.getTime("departure_time"));
        ticket.setPlace(resultSet.getInt("place"));
        ticket.setPrice(resultSet.getDouble("price"));
        ticket.setPaid(resultSet.getBoolean("paid"));
        ticket.setUserId(resultSet.getLong("user_id"));
        ticket.setTrailId(resultSet.getLong("trail_id"));

        return ticket;
    }
}
