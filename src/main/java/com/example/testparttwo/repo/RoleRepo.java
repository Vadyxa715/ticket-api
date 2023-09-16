package com.example.testparttwo.repo;

import com.example.testparttwo.entity.ERole;
import com.example.testparttwo.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo {

    Optional<Role> findByName(ERole name);
}
