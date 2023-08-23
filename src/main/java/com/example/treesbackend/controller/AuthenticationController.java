package com.example.treesbackend.controller;

import com.example.treesbackend.dto.LoginResponseDto;
import com.example.treesbackend.dto.RegistrationDto;
import com.example.treesbackend.model.Role;
import com.example.treesbackend.model.User;
import com.example.treesbackend.repository.RoleRepository;
import com.example.treesbackend.repository.UserRepository;
import com.example.treesbackend.service.AuthenticationService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<RegistrationDto> registerUser(@RequestBody RegistrationDto body){
        return ResponseEntity.ok(authenticationService.registerUser(body.getUsername(),body.getPassword()));
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody RegistrationDto body){
        return ResponseEntity.ok(authenticationService.loginUser(body.getUsername(), body.getPassword()));
    }
    //delete from here
    @Autowired
    RoleRepository roleRepository;
    @GetMapping("/roles")
    public String role(){
        Role adminRole = roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("USER"));
        return "";
    }


}
