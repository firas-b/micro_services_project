package com.example.userservice.user;

import org.springframework.stereotype.Component;

@Component
public class DTOMapper {



    public    User toUser (UserRequest request) {
        if (request == null) {
            return null;
        }
        return  User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .role(request.role())
                .address(request.address())
                .build();
    }

    public UserResponse toUserResponse(User user) {
        if (user == null) {return null;}
         return new UserResponse(
                 user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getRole(),
                user.getAddress(),
                 user.isIsactive()
        );


    }
}
