package com.example.testparttwo.repo.impl;

import com.example.testparttwo.entity.Transporter;
import com.example.testparttwo.repo.TransporterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransporterRepoImpl implements TransporterRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(Transporter transporter) {
        return jdbcTemplate.update("INSERT INTO transporters (name, phone) VALUES(?,?)",
                transporter.getName(), transporter.getPhone());
        //new Object[]{ticket.getTicketId(), ticket.getDepartureTime(), ticket.getPlace(), ticket.getPrice(), ticket.getPaid()});
    }

    @Override
    public int update(Transporter transporter) {
        return jdbcTemplate.update("UPDATE transporters SET name=?, phone=? WHERE id=?",
                transporter.getName(), transporter.getPhone(), transporter.getTransporterId());
        //new Object[]{ticket.getDepartureTime(), ticket.getPlace(), ticket.getPrice(), ticket.getPaid(), ticket.getTicketId()});
    }

    @Override
    public Transporter findById(Long id) {
        try {
            Transporter transporter = jdbcTemplate.queryForObject("SELECT * FROM transporters WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Transporter.class), id);
            return transporter;
        }catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM transporters WHERE id=?", id);
    }

    @Override
    public List<Transporter> findAll() {
        return jdbcTemplate.query("SELECT * FROM transporters", BeanPropertyRowMapper.newInstance(Transporter.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE FROM transporters");
    }









}
