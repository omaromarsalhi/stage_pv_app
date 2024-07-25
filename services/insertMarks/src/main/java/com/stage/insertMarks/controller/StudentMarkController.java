package com.stage.insertMarks.controller;

import com.stage.insertMarks.entity.StudentMark;
import com.stage.insertMarks.service.StudentMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studentMarks")
public class StudentMarkController {

    @Autowired
    private StudentMarkService studentMarkService;

    @PostMapping
    public ResponseEntity<StudentMark> createStudentMark(@RequestBody StudentMark studentMark) {
        StudentMark savedStudentMark = studentMarkService.saveStudentMark(studentMark);
        return new ResponseEntity<>(savedStudentMark, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentMark>> getAllStudentMarks() {
        List<StudentMark> studentMarks = studentMarkService.getAllStudentMarks();
        return new ResponseEntity<>(studentMarks, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}/{markId}")
    public ResponseEntity<Void> deleteStudentMark(@PathVariable Integer studentId, @PathVariable Integer markId) {
        studentMarkService.deleteStudentMark(studentId, markId);
        return ResponseEntity.noContent().build();
    }

}

