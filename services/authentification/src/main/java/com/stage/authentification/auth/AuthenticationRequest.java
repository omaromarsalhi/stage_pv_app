package com.stage.authentification.auth;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AuthenticationRequest(
        @NotEmpty(message = "email must not be empty")
        @NotNull(message = "email must not be empty")
        String email,
        @NotEmpty(message = "password must not be empty")
        @NotNull(message = "password must not be empty")
        String password
) {
}
