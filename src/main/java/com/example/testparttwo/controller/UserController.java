package com.example.testparttwo.controller;

import com.example.testparttwo.dto.UserDto;
import com.example.testparttwo.servise.TicketService;
import com.example.testparttwo.servise.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/users",produces = "application/json; charset=utf-8")//ручная установка родировки для swagger3
public class UserController {
    private UserService userService;
    private TicketService ticketService;

    @Operation(summary = "Создать нового пользователя")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<?> createUser (@RequestBody UserDto userDto){
        UserDto saveUser = userService.createUser(userDto);
        //TO DO VALIDATION |"if не получилось"|
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Получить пользователя по  ID")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        UserDto getUser = userService.getUser(id);
        //TO DO VALIDATION
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }
}
