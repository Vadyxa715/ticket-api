package com.example.testparttwo.mapper;

import com.example.testparttwo.dto.UserDto;
import com.example.testparttwo.entity.User;

public class UserMapper {
    public static UserDto convert(User user) {
        if (user == null) return null;
        return new UserDto(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getFullName()
        );
    }

    public static User revert(UserDto userDto) {
        if (userDto == null) return null;
        return new User(
                userDto.getId(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getFullName()
        );
    }
}
