package com.example.testparttwo.repo;

import com.example.testparttwo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    @Override
    Optional<User> findById(Long aLong);
}
