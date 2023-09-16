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
    private Long id;
    private String login;
    private String password;
    private String fullName;

    //@MappedCollection(keyColumn = "role_id", idColumn = "role_id")
    private Role role;

//    @MappedCollection(keyColumn = "user_id", idColumn = "user_id")
//    private Set<Ticket> tickets;

    public User(Long userId, String login, String password, String fullName) {
        this.id = userId;
        this.login = login;
        this.password = password;
        this.fullName = fullName;
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
