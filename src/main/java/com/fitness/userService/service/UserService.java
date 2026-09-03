package com.fitness.userService.service;

import com.fitness.userService.dto.RegisterRequest;
import com.fitness.userService.dto.UserResponse;
import com.fitness.userService.models.User;
import com.fitness.userService.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public UserResponse register(RegisterRequest registerRequest) {

        if(userRepository.existsByEmail(registerRequest.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        User user=new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setName(registerRequest.getName());

       User savedUser= userRepository.save(user);
       UserResponse userResponse=new UserResponse();
       userResponse.setId(savedUser.getId());
       userResponse.setEmail(savedUser.getEmail());
       userResponse.setName(savedUser.getName());
       userResponse.setPassword(savedUser.getPassword());
       userResponse.setCreatedAt(savedUser.getCreatedAt());
       userResponse.setUpdatedAt(savedUser.getUpdatedAt());
       return userResponse;
    }

    public UserResponse getUserById(Long id) {
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("User doesnot exist"));
        UserResponse userResponse=new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setName(user.getName());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());
        return userResponse;
    }
}
