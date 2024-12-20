package com.example.userservice.auth;


public record LoginRequest(

        String tokenUrl, String clientId, String clientSecret, String username, String password
) {
}
