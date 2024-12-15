package com.example.userservice.keycloak;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/keyclaok_client")
@RequiredArgsConstructor
public class KeyclaokController {

    private final KeycloakClient keycloakClient;


    @GetMapping("/users")
    public List<?> getUsers() {
        return keycloakClient.getusers();
    }
}
