package com.stage.authentification.auth;

public record AuthenticationRequest(
        String email,
        String password
) {
}
