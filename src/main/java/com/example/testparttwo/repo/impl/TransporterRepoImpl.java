package com.example.testparttwo.repo.impl;

import com.example.testparttwo.entity.Transporter;
import com.example.testparttwo.repo.TransporterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TransporterRepoImpl implements TransporterRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public <S extends Transporter> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Transporter> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Transporter> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Transporter> findAll() {
        return null;
    }

    @Override
    public Iterable<Transporter> findAllById(Iterable<Long> longs) {
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
    public void delete(Transporter entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Transporter> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
