package com.example.testparttwo.repo;

import com.example.testparttwo.entity.Transporter;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporterRepo {

    int save(Transporter transporter);
    Transporter findById(Long id);
}
