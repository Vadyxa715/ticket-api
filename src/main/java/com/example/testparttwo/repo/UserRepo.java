package com.example.testparttwo.repo;

import com.example.testparttwo.entity.ERole;
import com.example.testparttwo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo {
    int save(User user);

    User findById(Long id);

    List<User> findAll();

    User findByLogin(String login);

    User findByRole(ERole role);
}
