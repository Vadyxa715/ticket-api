package com.example.testparttwo.controller;

import com.example.testparttwo.controller.customException.EntityNotFoundException;
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
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
            userService.createUser(new UserDto(
                    userDto.getLogin(),
                    userDto.getPassword(),
                    userDto.getFullName()
            ));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить пользователя по  ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        UserDto getUser = userService.getUser(id);
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

    @Operation(summary = "Получить всех пользоватей")
    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDto>> getAllUser() {
            List<UserDto> usersDto = new ArrayList<UserDto>(userService.findAll());
            return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @Operation(summary = "Получить пользователя по login")
    @GetMapping(value = "/byLogin{login}")
    public ResponseEntity<UserDto> getByLogin(@PathVariable(value = "login") String login){
        UserDto getUser = userService.getByLogin(login);
        return new ResponseEntity<>(getUser,HttpStatus.OK);
    }
}
