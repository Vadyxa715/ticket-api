package com.example.testparttwo.repo;

import com.example.testparttwo.entity.Transporter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransporterRepo {

    int save(Transporter transporter);
    Transporter findById(Long id);
}
