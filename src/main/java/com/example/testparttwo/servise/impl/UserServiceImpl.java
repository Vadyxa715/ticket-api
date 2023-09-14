package com.example.testparttwo.servise.impl;

import com.example.testparttwo.dto.UserDto;
import com.example.testparttwo.entity.User;
import com.example.testparttwo.mapper.UserMapper;
import com.example.testparttwo.repo.UserRepo;
import com.example.testparttwo.servise.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.revert(userDto);
        int saveUser = userRepo.save(user);
        User inserted = userRepo.findById((long) saveUser);
        return UserMapper.convert(inserted);
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepo.findById(userId);
        return UserMapper.convert(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepo.findAll();
        return users.stream().map(UserMapper::convert).toList();
    }
}