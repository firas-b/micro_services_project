package com.example.userservice.user;

import jakarta.annotation.Nullable;
import lombok.Builder;



public record UserRequest(
         String id,
         String firstName,
         String lastName,
         String email,
         String phone,
         Role role,
         Address address ,
         @Nullable
         String password

) {
}




