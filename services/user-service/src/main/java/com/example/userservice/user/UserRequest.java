package com.example.userservice.user;

import lombok.Builder;

@Builder

public record UserRequest(
         String id,
         String firstName,
         String lastName,
         String email,
         String phone,
         Role role,
         Address address

) {
}




