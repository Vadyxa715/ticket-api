package com.example.testparttwo.security.services;

import com.example.testparttwo.entity.User;
import com.example.testparttwo.repo.RoleRepo;
import com.example.testparttwo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepo.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with login: " + login));
        user.setRole(roleRepo.findById(user.getRoleId()).orElse(null));

        return UserDetailsImpl.build(user);
    }
}
