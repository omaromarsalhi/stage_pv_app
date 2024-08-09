package com.stage.insertMarks.controller;

import com.stage.insertMarks.entity.GradeProfessor;
import com.stage.insertMarks.entity.GradeProfessorId;
import com.stage.insertMarks.service.GradeProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grade-professors")
@CrossOrigin(origins = "http://localhost:3000/")
public class GradeProfessorController {
    @Autowired
    private GradeProfessorService gradeProfessorService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping
    public List<GradeProfessor> getAllGradeProfessors() {
        return gradeProfessorService.getAllGradeProfessors();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/{idUser}/{idGrade}")
    public GradeProfessor getGradeProfessorById(@PathVariable Integer idUser, @PathVariable Integer idGrade) {
        GradeProfessorId id = new GradeProfessorId(idUser, idGrade);
        return gradeProfessorService.getGradeProfessorById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping
    public GradeProfessor createGradeProfessor(@RequestBody GradeProfessor gradeProfessor) {
        return gradeProfessorService.saveGradeProfessor(gradeProfessor);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/{idUser}/{idGrade}")
    public void deleteGradeProfessor(@PathVariable Integer idUser, @PathVariable Integer idGrade) {
        GradeProfessorId id = new GradeProfessorId(idUser, idGrade);
        gradeProfessorService.deleteGradeProfessor(id);
    }
}

