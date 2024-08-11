package com.stage.insertMarks.user;

import com.stage.insertMarks.marks.MarksDto;

public record StudentResponse(
        int idUser,
        String firstName,
        String lastName,
        String email
) {
}
