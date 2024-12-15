package com.example.blogservice.user;

import lombok.Builder;
import lombok.Data;

@Builder

public record UserResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        boolean isactive) {


}
