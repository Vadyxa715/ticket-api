package com.example.testparttwo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(description = "Пароль", accessMode = Schema.AccessMode.READ_ONLY)
    private String password;
    private String login;
    private String fullName;

    public UserDto(String password, String login, String fullName) {
        this.password = password;
        this.login = login;
        this.fullName = fullName;
    }
}
