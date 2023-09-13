package com.example.testparttwo.repo;

import com.example.testparttwo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo {
    int save (User user);
    User findById(Long id);
    List<User> findAll();
}
