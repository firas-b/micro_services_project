package com.example.userservice.user;

import lombok.Builder;


public record UserResponse(
         String id,
         String keycloakId,
         String firstName,
         String lastName,
         String email,
         String phone,
         Role role,
         Address address,
         boolean isactive) {


}
