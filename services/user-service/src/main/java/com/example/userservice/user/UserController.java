package com.example.userservice.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/current")
    public Map<String, Object> getCurrentUser( Authentication authentication ) {
        // Retrieve the current authentication object


        if (authentication == null || !(authentication.getPrincipal() instanceof Jwt)) {
            throw new IllegalStateException("No authenticated user found");
        }

        // Extract JWT claims
        Jwt jwt = (Jwt) authentication.getPrincipal();
        return jwt.getClaims();
    }

        @GetMapping("/debug-headers")
        public Map<String, String> debugHeaders(@RequestHeader Map<String, String> headers) {
            return headers;
        }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/add")
    public ResponseEntity <String> add(@RequestBody @Valid UserRequest user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserResponse> get(@PathVariable("user-id") String id){
        return ResponseEntity.ok(userService.getUser(id));
    }
    @DeleteMapping("/{user-id}")
    public ResponseEntity<String> delete(@PathVariable("user-id") String id){
       return ResponseEntity.ok( userService.deleteUser(id));

    }

}
