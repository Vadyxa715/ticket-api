package com.example.testparttwo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Schema(description = "id пользователя", example = "1")
    private Long id;
    @Schema(description = "зашифрованный пароль пользователя", example = "$2a$10$ozhNvvizNSLuWXg6YflR/.j1nIb1UAC84HHeZt4tK6ISrb1dpoq6C", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
    @Schema(description = "уникальный логин", example = "Test", requiredMode = Schema.RequiredMode.REQUIRED)
    private String login;
    @Schema(description = "инициалы пользователя", example = "Иванов Иван Иванович", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String fullName;

    public UserDto(String password, String login, String fullName) {
        this.password = password;
        this.login = login;
        this.fullName = fullName;
    }
}
