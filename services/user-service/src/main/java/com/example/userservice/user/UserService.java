package com.example.userservice.user;


import com.example.userservice.exceptions.UserNotFoundExc;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final DTOMapper dtoMapper;

    public String createUser(UserRequest request) {
        var user = userRepository.save(dtoMapper.toUser(request));
        return user.getId();
    }

    public UserResponse getUser(String id) {
       return userRepository.findById(id).map(dtoMapper::toUserResponse).orElseThrow(()-> new UserNotFoundExc(String.format("No User found with the provided ID: %s", id)));
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
