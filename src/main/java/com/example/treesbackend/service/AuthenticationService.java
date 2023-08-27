package com.example.treesbackend.service;

import com.example.treesbackend.dto.LoginResponseDto;
import com.example.treesbackend.dto.RegistrationDto;
import com.example.treesbackend.model.Role;
import com.example.treesbackend.model.User;
import com.example.treesbackend.repository.RoleRepository;
import com.example.treesbackend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public RegistrationDto registerUser(String username, String password){
        String encodedPassword = passwordEncoder.encode(password);

        Role userRole = roleRepository.findByAuthority("USER").get();


        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);
        userRepository.save(new User(0,username,encodedPassword,authorities));
        return new RegistrationDto(username,encodedPassword);
    }

    public LoginResponseDto loginUser(String username, String password){

        try{
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginResponseDto(userRepository.findByUsername(username).get(), token);

        } catch(AuthenticationException e){
            return new LoginResponseDto(null, "");
        }
    }
}
