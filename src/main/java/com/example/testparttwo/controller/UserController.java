package com.example.testparttwo.controller;

import com.example.testparttwo.dto.UserDto;
import com.example.testparttwo.servise.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/users", produces = "application/json; charset=utf-8")
@SecurityRequirement(name = "Authorization")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Создать нового пользователя")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        try {
            userService.createUser(new UserDto(
                    userDto.getLogin(),
                    userDto.getPassword(),
                    userDto.getFullName()
            ));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить пользователя по  ID")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        UserDto getUser = userService.getUser(id);
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

    @Operation(summary = "Получить всех пользоватей")
    @RequestMapping(method = RequestMethod.GET, value = "/allUsers")
    public ResponseEntity<List<UserDto>> getAllUser() {
        try {
            List<UserDto> usersDto = new ArrayList<UserDto>(userService.findAll());
            return new ResponseEntity<>(usersDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Получить пользователя по login")
    @RequestMapping(method = RequestMethod.GET, value = "/getByLogin{login}")
    public ResponseEntity<UserDto> getByLogin(@PathVariable(value = "login") String login){
        UserDto getUser = userService.getByLogin(login);
        return new ResponseEntity<>(getUser,HttpStatus.OK);
    }
}
