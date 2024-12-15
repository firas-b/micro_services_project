package com.example.userservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserNotFoundExc extends RuntimeException {
   private final String msg ;
}
