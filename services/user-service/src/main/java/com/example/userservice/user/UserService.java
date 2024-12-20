package com.example.userservice.user;


import com.example.userservice.common.DTOMapper;
import com.example.userservice.exceptions.UserNotFoundExc;
import com.example.userservice.keycloak.KeycloakClient;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final DTOMapper dtoMapper;
    private final KeycloakClient keycloakClient;


    public String createUser(UserRequest request) {
        // Add user to Keycloak
        var userRepresentation = dtoMapper.toUserRepresentation(request);
        Response response = keycloakClient.addUser(userRepresentation);

        if (response.getStatus() != 201) {
            throw new RuntimeException("Failed to create user in Keycloak: " + response.getStatus());
        }

        // Extract Keycloak user ID
        String keycloakId = extractKeycloakId(response);

        // Save user in the repository (transactional boundary)
        return saveUserInDatabase(request, keycloakId);
    }
    private String extractKeycloakId(Response response) {
        // Extract the "Location" header from the response
        String locationHeader = response.getHeaders().getFirst("Location").toString();
        if (locationHeader == null || !locationHeader.contains("/")) {
            throw new RuntimeException("Failed to retrieve Keycloak user ID from response.");
        }
        // Extract the ID by splitting the URL
        return locationHeader.substring(locationHeader.lastIndexOf('/') + 1);
    }

    public String saveUserInDatabase(UserRequest request, String keycloakId) {
        if(keycloakId == null) {
            throw new RuntimeException("KeycloakId cannot be null");

        }
        var userEntity = dtoMapper.toUser(request);
        userEntity.setKeycloakId(keycloakId);
        var savedUser = userRepository.save(userEntity);
        return savedUser.getId();
    }


    public UserResponse getUser(String id) {
       return userRepository.findById(id).map(dtoMapper::toUserResponse).orElseThrow(()-> new UserNotFoundExc(String.format("No User found with the provided ID: %s", id)));
    }
    public UserResponse getUserbykeyclaokIDd(String id) {
        return userRepository.findByKeycloakId(id).map(dtoMapper::toUserResponse).orElseThrow(()-> new UserNotFoundExc(String.format("No User found with the provided keyclaok_id: %s", id)));
    }

    public List<UserResponse> getAllUsers() {

        return userRepository.findAll().stream().map(dtoMapper::toUserResponse).collect(Collectors.toList());
    }
    public boolean existsById(String id) {
        return userRepository.findById(id)
                .isPresent();
    }



    public String deleteUser(String id) {
       Optional <User> user = userRepository.findById(id);
       if(user.isPresent()) {
          User deletedUser = user.get();
          deletedUser.setIsactive(false);
          userRepository.save(deletedUser);
          return deletedUser.getId();
       }
        else return "User Not Found";
    }
}
