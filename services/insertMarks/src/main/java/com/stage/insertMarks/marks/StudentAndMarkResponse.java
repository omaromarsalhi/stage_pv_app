package com.stage.insertMarks.marks;

import com.stage.insertMarks.user.StudentResponse;
import lombok.Builder;


@Builder
public record StudentAndMarkResponse(
        StudentResponse student,
        MarksDto marks
) {
}
