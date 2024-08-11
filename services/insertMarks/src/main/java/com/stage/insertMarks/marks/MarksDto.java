package com.stage.insertMarks.marks;


import lombok.Builder;

@Builder
public record MarksDto(
        float exam,
        float tp,
        float cc
) {
}
