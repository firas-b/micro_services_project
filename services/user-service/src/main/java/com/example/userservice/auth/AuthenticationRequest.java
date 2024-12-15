package com.example.userservice.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthenticationRequest {
    @Email
    private String email;
    @NotNull
    private String password;

}
