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

        public UserDto(String password, String login, String fullName) {
                this.password = password;
                this.login = login;
                this.fullName = fullName;
        }
}
