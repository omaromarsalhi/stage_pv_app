package com.stage.gateway.handler;


import com.stage.gateway.exeption.TokenMissingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(TokenMissingException.class)
    public ResponseEntity<?> handleTokenExpiredException(TokenMissingException exp) {
        Map<String, String> errors = new HashMap<>();
        errors.put("token", exp.getMessage());
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(errors);
    }

}