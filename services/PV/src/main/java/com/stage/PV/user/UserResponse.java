package com.stage.PV.user;

public record UserResponse(
        int idUser,
        String identifier,
        String firstName,
        String lastName,
        String email,
        int idGrade,
        String role
        ) {
}
