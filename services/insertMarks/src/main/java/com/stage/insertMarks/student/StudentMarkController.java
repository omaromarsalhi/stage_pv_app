package com.stage.insertMarks.student;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/insertMarks/student")
@AllArgsConstructor
public class StudentMarkController {

    private final StudentMarkService studentMarkService;

    @PostMapping("/insert")
    public ResponseEntity<Void> insertStudentMark(
            @RequestParam int studentId,
            @RequestParam int moduleId,
            @RequestParam float markCc,
            @RequestParam float markExam,
            @RequestParam float markTp
    ) {
        studentMarkService.insertStudentMark(studentId, moduleId, markCc, markExam, markTp);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<StudentMark>> getStudentMarks(@PathVariable int studentId) {
        return ResponseEntity.ok(studentMarkService.getStudentMarks(studentId));
    }
}
