package com.example.treesbackend.dto;

import com.example.treesbackend.model.User;

public class LoginResponseDto {
    private User user;
    private String jwt;

    public LoginResponseDto() {
    }

    public LoginResponseDto(User user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
