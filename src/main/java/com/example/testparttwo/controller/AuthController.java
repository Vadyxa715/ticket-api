package com.example.testparttwo.controller;

import com.example.testparttwo.dto.UserDto;
import com.example.testparttwo.entity.User;
import com.example.testparttwo.repo.UserRepo;
import com.example.testparttwo.servise.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/auth", produces = "application/json; charset=utf-8")
public class AuthController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final UserRepo userRepo;

    @Operation(summary = "регистрация пользователя")
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public @ResponseBody com.example.testparttwo.entity.User getAuthUser(){
    //public User getAuthUser(@RequestBody User user){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        User user = (principal instanceof User) ? (User) principal : null;
        //UserDto userDto = (principal instanceof UserDto) ? (UserDto) principal : null;
        return Objects.nonNull(user) ? this.userRepo.findByLogin(user.getLogin()) : null;
        //return Objects.nonNull(userDto) ? this.userService.getByLogin(userDto.getLogin()) : null;
    }
}
