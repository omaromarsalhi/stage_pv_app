package com.stage.insertMarks.marks;

import java.util.Map;

public record MarksCredentials(
        int idModule,
        Map<Integer,MarksDto> marks
) {
}
