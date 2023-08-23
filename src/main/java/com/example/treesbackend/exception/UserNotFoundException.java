package com.example.treesbackend.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Could not find the user with id "+ id);
    }
    public UserNotFoundException(String name){
        super("Could not find the user "+ name);
    }
}
