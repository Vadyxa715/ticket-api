package com.example.testparttwo.repo.impl;

import com.example.testparttwo.entity.Trail;
import com.example.testparttwo.repo.TrailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TrailRepoImpl implements TrailRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public <S extends Trail> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Trail> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Trail> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Trail> findAll() {
        return null;
    }

    @Override
    public Iterable<Trail> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Trail entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Trail> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
