package com.stage.authentification.exeption;

public class TokenExpiredException extends RuntimeException {
    public TokenExpiredException(String invalidToken) {
        super(invalidToken);
    }
}
