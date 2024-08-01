package com.stage.PV.grade;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/pv/grades")
public class GradeController {

    private final GradeService gradeService;

    @PostMapping("/{level}")
    public ResponseEntity<List<Grade>> getAllGrades(
            @PathVariable("level") String level
    ) {
        return ResponseEntity.ok(gradeService.getAllGrades(level));
    }

}
