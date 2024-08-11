package com.stage.insertMarks.user;

public record StudentResponse(
        int idUser,
        String firstName,
        String lastName,
        String email
) {
}
