package com.example.testparttwo.repo;

import com.example.testparttwo.entity.Trail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailRepo extends JpaRepository<Trail, Long> {
}
