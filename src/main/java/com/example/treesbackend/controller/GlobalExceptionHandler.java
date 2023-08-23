package com.example.treesbackend.controller;

import com.example.treesbackend.exception.PostNotFoundException;
import com.example.treesbackend.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({UserNotFoundException.class})
    ResponseEntity<Object> handleUserNotFoundException(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({PostNotFoundException.class})
    ResponseEntity<Object> handlePostNotFoundException(){
        return  ResponseEntity.notFound().build();
    }
}
