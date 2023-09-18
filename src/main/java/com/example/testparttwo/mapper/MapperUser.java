package com.example.testparttwo.mapper;

import com.example.testparttwo.dto.UserDto;
import com.example.testparttwo.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface MapperUser {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
}
