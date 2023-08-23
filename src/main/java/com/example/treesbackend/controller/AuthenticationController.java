package com.example.treesbackend.controller;

import com.example.treesbackend.dto.LoginResponseDto;
import com.example.treesbackend.dto.RegistrationDto;
import com.example.treesbackend.model.Role;
import com.example.treesbackend.model.User;
import com.example.treesbackend.repository.RoleRepository;
import com.example.treesbackend.repository.UserRepository;
import com.example.treesbackend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationDto body){
        return authenticationService.registerUser(body.getUsername(),body.getPassword());
    }
    @PostMapping("/login")
    public LoginResponseDto loginUser(@RequestBody RegistrationDto body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }


}
