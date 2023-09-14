package com.example.testparttwo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Data
@NoArgsConstructor
@Table("user")
public class User {

    @Id
    private Long id;
    private String login;
    private String password;
    private String fullName;

    @MappedCollection(keyColumn = "USER_ID", idColumn = "USER_ID")
    private Set<Ticket> tickets;

    public User(Long userId, String login, String password, String fullName) {
        this.id = userId;
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }
}
