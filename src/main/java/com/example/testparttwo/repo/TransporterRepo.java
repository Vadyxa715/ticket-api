package com.example.testparttwo.repo;

import com.example.testparttwo.entity.Transporter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransporterRepo extends CrudRepository<Transporter, Long> {
    @Override
    Optional<Transporter> findById(Long aLong);
}
