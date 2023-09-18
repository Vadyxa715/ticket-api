package com.example.testparttwo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Schema(name = "Идентификатор", description = "id пользователя", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    @Schema(name = "Пароль", description = "зашифрованный пароль пользователя", example = "$2a$10$ozhNvvizNSLuWXg6YflR/.j1nIb1UAC84HHeZt4tK6ISrb1dpoq6C", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
    @Schema(name = "Имя", description = "уникальный логин", example = "Test", requiredMode = Schema.RequiredMode.REQUIRED)
    private String login;
    @Schema(name = "ФИО", description = "инициалы пользователя", example = "Иванов Иван Иванович", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String fullName;

    public UserDto(String password, String login, String fullName) {
        this.password = password;
        this.login = login;
        this.fullName = fullName;
    }
}
