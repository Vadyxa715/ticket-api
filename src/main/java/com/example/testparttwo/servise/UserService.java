package com.example.testparttwo.servise;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUser(Long userId);

    List<UserDto> findAll();

    UserDto getByLogin(String login);

}