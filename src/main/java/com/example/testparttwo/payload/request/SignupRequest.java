package com.example.testparttwo.payload.request;

import com.example.testparttwo.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String login;

    private Role role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
