package com.example.treesbackend.dto;

import org.springframework.context.annotation.Bean;

public final class RegistrationDto {

    private String username;
    private String password;

    public RegistrationDto() {
        super();
    }

    public RegistrationDto(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "Registration info username: "+username+" password: "+password ;
    }
}
