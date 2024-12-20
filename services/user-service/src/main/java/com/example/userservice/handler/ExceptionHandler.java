package com.example.userservice.handler;

import com.example.userservice.exceptions.KeycloakException;
import com.example.userservice.exceptions.UserNotFoundExc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundExc.class)
    public ResponseEntity<String> userNotFoundExc(UserNotFoundExc userNotFoundExc) {

        return new ResponseEntity<>(userNotFoundExc.getMsg(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(KeycloakException.class)
    public ResponseEntity<String> keycloakExc(KeycloakException keycloakExc) {

        return new ResponseEntity<>(keycloakExc.getMsg(), HttpStatus.NOT_FOUND);
    }
}
