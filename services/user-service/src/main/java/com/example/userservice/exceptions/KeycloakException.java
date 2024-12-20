package com.example.userservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class KeycloakException extends RuntimeException {
    private final String msg ;
}
