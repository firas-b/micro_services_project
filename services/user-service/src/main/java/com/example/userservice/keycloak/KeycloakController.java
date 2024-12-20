package com.example.userservice.keycloak;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users/keycloak")
@RequiredArgsConstructor
public class KeycloakController {

    private final KeycloakClient keycloakClient;

    @GetMapping("/users")
    public List<?> getUsers() {
        return keycloakClient.getusers();
    }
    @PostMapping("/auth/name")
    public Object login(Authentication connecteduser) {
      return  connecteduser.getName();
    }
}
