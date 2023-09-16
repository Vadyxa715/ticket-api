package com.example.testparttwo.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String login;
    private String roles;

    public JwtResponse(String accessToken, Long id, String login, String roles) {
        this.token = accessToken;
        this.id = id;
        this.login = login;
        this.roles = roles;
    }

}
