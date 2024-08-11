package com.stage.insertMarks.marks;

import lombok.Builder;

import java.util.List;


@Builder
public record ProfessorResponse(
        List<ProfessorData> data
) {
}
