package com.authservice_1.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authservice_1.dto.ApiResponse;
import com.authservice_1.dto.UserDto;
import com.authservice_1.entity.User;
import com.authservice_1.reposiotory.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ApiResponse<String> register(UserDto userDto) {

        ApiResponse<String> response = new ApiResponse<>();

        // Check whether username exists
        if (userRepository.existsByUsername(userDto.getUsername())) {
            response.setMessage("Registration Failed");
            response.setStatus(500);
            response.setData("User with username already exists");
            return response;
        }

        // Check whether email exists
        if (userRepository.existsByEmail(userDto.getEmail())) {
            response.setMessage("Registration Failed");
            response.setStatus(500);
            response.setData("User with email ID already exists");
            return response;
        }

        // Encode password before saving
        String encryptedPassword = passwordEncoder.encode(userDto.getPassword());

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setPassword(encryptedPassword);

        User savedUser =userRepository.save(user);
        
        if(savedUser==null) {
        	
        }

        response.setMessage("Registration Successful");
        response.setStatus(200);
        response.setData("User registered successfully");

        return response;
    }
}
