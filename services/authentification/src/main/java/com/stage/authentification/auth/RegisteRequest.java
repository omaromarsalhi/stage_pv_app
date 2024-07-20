package com.stage.authentification.auth;

public record RegisteRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
