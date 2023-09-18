package com.example.testparttwo.repo.impl;

import com.example.testparttwo.entity.Trail;
import com.example.testparttwo.repo.TrailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TrailRepoImpl implements TrailRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Trail findById(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM trails WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Trail.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int save(Trail trail) {
        return jdbcTemplate.update("INSERT INTO trails (point_departure, point_arrival, duration, transporter_id) VALUES(?,?,?,?)",
                trail.getPointDeparture(), trail.getPointArrival(), trail.getDuration(), trail.getTrailId());
    }
}
