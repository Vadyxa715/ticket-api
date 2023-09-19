package com.example.testparttwo.servise.impl;

import com.example.testparttwo.controller.customException.EntityBadRequestException;
import com.example.testparttwo.controller.customException.EntityNotFoundException;
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
        if (inserted == null) {
            throw new EntityBadRequestException("Failed to create userEntity.");
        }
        return mapperUser.toDto(inserted);
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepo.findById(userId);
        if(user == null){
            throw new EntityNotFoundException("Not found user by ID: " + userId + ".");
        }
        return mapperUser.toDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepo.findAll();
        if(users.isEmpty()){
            throw new EntityNotFoundException("Not found users.");
        }
        return users.stream().map(mapperUser::toDto).toList();
    }

    @Override
    public UserDto getByLogin(String login) {
        User user = userRepo.findByLogin(login).orElse(null);
        if(user == null){
            throw new EntityNotFoundException("Not found user by login: " + login + ".");
        }
        return mapperUser.toDto(user);
    }


}