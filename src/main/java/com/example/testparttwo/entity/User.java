package com.example.testparttwo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("user")
public class User {

    @Id
    private Long id;
    private String login;
    private String password;
    private String fullName;
    private Role role;

    @MappedCollection(keyColumn = "role_id", idColumn = "role_id")
    private Long roleId;

    public User(Long userId, String login, String password, String fullName) {
        this.id = userId;
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public User(Long id, String login, String password, Role role, Long roleId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.roleId = roleId;
    }

    public User(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
