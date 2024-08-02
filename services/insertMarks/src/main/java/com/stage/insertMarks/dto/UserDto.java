package com.stage.insertMarks.dto;


import lombok.Builder;

@Builder
public record UserDto(
        int idUser,
        String identifier,
        String firstName,
        String lastName,
        String email,
        Integer idGrade,
        String role
) {
}
