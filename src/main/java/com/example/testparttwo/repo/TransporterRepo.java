package com.example.testparttwo.repo;

import com.example.testparttwo.entity.Transporter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransporterRepo {

    int save(Transporter transporter);

    int update(Transporter transporter);

    Transporter findById(Long id);

    int deleteById(Long id);

    List<Transporter> findAll();

    int deleteAll();
}
