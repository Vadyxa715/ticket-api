package com.example.testparttwo.repo.impl;

import com.example.testparttwo.entity.Transporter;
import com.example.testparttwo.repo.TransporterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransporterRepoImpl implements TransporterRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Transporter transporter) {
        return jdbcTemplate.update("INSERT INTO transporters (name, phone) VALUES(?,?)",
                transporter.getName(), transporter.getPhone());
    }
    @Override
    public Transporter findById(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM transporters WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Transporter.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
