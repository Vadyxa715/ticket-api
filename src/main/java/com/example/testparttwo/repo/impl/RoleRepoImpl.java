package com.example.testparttwo.repo.impl;

import com.example.testparttwo.entity.ERole;
import com.example.testparttwo.entity.Role;
import com.example.testparttwo.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleRepoImpl implements RoleRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Role> findByName(ERole name) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM roles WHERE role=?",
                    BeanPropertyRowMapper.newInstance(Role.class), name.name()));
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.empty();
        }
    }
}
