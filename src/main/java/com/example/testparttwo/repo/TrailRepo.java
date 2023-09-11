package com.example.testparttwo.repo;

import com.example.testparttwo.entity.Trail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrailRepo extends CrudRepository<Trail, Long> {
    @Override
    Optional<Trail> findById(Long aLong);
}
