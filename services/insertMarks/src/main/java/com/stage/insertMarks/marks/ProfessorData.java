package com.stage.insertMarks.marks;

import lombok.Builder;

import java.util.List;
import java.util.Map;


@Builder
public record ProfessorData(
        String gradeName,
        String moduleName,
        int moduleId
) {
}
