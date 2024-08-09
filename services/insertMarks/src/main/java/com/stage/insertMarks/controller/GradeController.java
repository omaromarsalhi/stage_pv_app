package com.stage.insertMarks.controller;

import com.stage.insertMarks.entity.Grade;
import com.stage.insertMarks.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@CrossOrigin(origins = "http://localhost:3000/")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/{id}")
    public Grade getGradeById(@PathVariable Integer id) {
        return gradeService.getGradeById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.saveGrade(grade);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Integer id) {
        gradeService.deleteGrade(id);
    }
}

