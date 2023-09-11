package com.example.testparttwo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("user")
public class User {

    @Id
    private Long userId;
    private String login;
    private String password;
    private String fullName;//ФИО

    public User(Long userId, String login, String password, String fullName) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }
}
