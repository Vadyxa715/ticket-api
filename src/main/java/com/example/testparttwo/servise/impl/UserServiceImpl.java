package com.example.testparttwo.servise.impl;

import com.example.testparttwo.dto.UserDto;
import com.example.testparttwo.entity.User;
import com.example.testparttwo.mapper.MapperUser;
import com.example.testparttwo.repo.UserRepo;
import com.example.testparttwo.servise.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final MapperUser mapperUser;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapperUser.toEntity(userDto);
        int saveUser = userRepo.save(user);
        User inserted = userRepo.findById((long) saveUser);
        return mapperUser.toDto(inserted);
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepo.findById(userId);
        return mapperUser.toDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepo.findAll();
        return users.stream().map(mapperUser::toDto).toList();
    }

    @Override
    public UserDto getByLogin(String login) {
        User user = userRepo.findByLogin(login);
        return mapperUser.toDto(user);
    }
}