package com.example.testparttwo.repo.impl;

import com.example.testparttwo.entity.Ticket;
import com.example.testparttwo.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
                ticket.getDepartureTime(), ticket.getPlace(), ticket.getPrice(), ticket.getPaid(), ticket.getUser().getUserId(), ticket.getTrail().getTrailId());
    }

    @Override
    public int update(Ticket ticket) {
        return jdbcTemplate.update("UPDATE tickets SET departure_time=?, place=?, price=?, paid=? WHERE id=?",
                ticket.getDepartureTime(), ticket.getPlace(), ticket.getPrice(), ticket.getPaid(), ticket.getTicketId());
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
        return null;
    }
}
