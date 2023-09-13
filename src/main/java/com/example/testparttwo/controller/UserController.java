package com.example.testparttwo.controller;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.dto.UserDto;
import com.example.testparttwo.entity.Ticket;
import com.example.testparttwo.entity.User;
import com.example.testparttwo.servise.TicketService;
import com.example.testparttwo.servise.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/users",produces = "application/json; charset=utf-8")//ручная установка родировки для swagger3
public class UserController {
    private UserService userService;
    private TicketService ticketService;

    @Operation(summary = "Создать нового пользователя")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<UserDto> createUser (@RequestBody UserDto userDto){

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
    public ResponseEntity<?> getUser(@PathVariable Long id){
        UserDto getUser = userService.getUser(id);
        //TO DO VALIDATION
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

    @Operation(summary = "Получить всех пользоватей")
    @RequestMapping(method = RequestMethod.GET, value = "/allUsers")
    public ResponseEntity<List<UserDto>> getAllUser(){
        try {
            List<UserDto> usersDto = new ArrayList<UserDto>();
            userService.findAll().forEach(usersDto::add);
            return new ResponseEntity<>(usersDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
