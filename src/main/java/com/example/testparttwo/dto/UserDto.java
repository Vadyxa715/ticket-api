package com.example.testparttwo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
        private Long id;
        private String password;
        private String login;
        private String fullName;
}
