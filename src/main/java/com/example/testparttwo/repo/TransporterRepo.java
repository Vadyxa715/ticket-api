package com.example.testparttwo.repo;

import com.example.testparttwo.entity.Transporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporterRepo extends JpaRepository<Transporter, Long> {
}
