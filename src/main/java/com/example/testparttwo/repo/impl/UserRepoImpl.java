package com.example.testparttwo.repo.impl;

import com.example.testparttwo.entity.User;
import com.example.testparttwo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepoImpl implements UserRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {
        return jdbcTemplate.update("INSERT INTO users(login, password, full_name) VALUES(?, ?, ?)",
                user.getLogin(), user.getPassword(), user.getFullName());
    }

    @Override
    public User findById(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?",
                    BeanPropertyRowMapper.newInstance(User.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users",
                BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public Optional<User> findByLogin(String login) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM users WHERE login=?",
                    BeanPropertyRowMapper.newInstance(User.class), login));
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Boolean existsByLogin(String login) {
        return jdbcTemplate.queryForObject("SELECT EXISTS (SELECT * FROM users WHERE login=?)",
                Boolean.class, login);
    }
}
