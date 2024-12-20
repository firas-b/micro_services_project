package com.example.userservice.common;

import com.example.userservice.user.User;
import com.example.userservice.user.UserRequest;
import com.example.userservice.user.UserResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DTOMapper {



    public User toUser (UserRequest request) {
        if (request == null) {
            return null;
        }
        return  User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .role(request.role())
                .isactive(true)
                .address(request.address())
                .build();
    }

    public UserRepresentation toUserRepresentation(UserRequest user) {
        if (user == null) {
            return null;
        }


        List<String> roles = new ArrayList<>();
        roles.add(user.role().name());


        Map<String, List<String>> clientRoles = new HashMap<>();
        clientRoles.put("microservices", roles);


        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setFirstName(user.firstName());
        userRepresentation.setLastName(user.lastName());
        userRepresentation.setEmail(user.email());
        userRepresentation.setEnabled(true);
        userRepresentation.setEmailVerified(true);

        userRepresentation.setClientRoles(clientRoles);
        userRepresentation.setUsername(user.email());

        if (user.password() != null) {
            CredentialRepresentation credential = new CredentialRepresentation();
            credential.setType(CredentialRepresentation.PASSWORD);
            credential.setValue(user.password());
            credential.setTemporary(false);
            userRepresentation.setCredentials(Collections.singletonList(credential));
        }

        return userRepresentation;
    }
    public UserResponse toUserResponse(User user) {
        if (user == null) {return null;}
         return new UserResponse(
                 user.getId(),
                 user.getKeycloakId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getRole(),
                user.getAddress(),
                 user.isIsactive()
        ) ;




    }
}
