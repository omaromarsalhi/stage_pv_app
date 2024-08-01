package com.stage.insertMarks.controller;

import com.stage.insertMarks.entity.GradeProfessor;
import com.stage.insertMarks.entity.GradeProfessorId;
import com.stage.insertMarks.service.GradeProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade-professors")
public class GradeProfessorController {
    @Autowired
    private GradeProfessorService gradeProfessorService;

    @GetMapping
    public List<GradeProfessor> getAllGradeProfessors() {
        return gradeProfessorService.getAllGradeProfessors();
    }

    @GetMapping("/{idUser}/{idGrade}")
    public GradeProfessor getGradeProfessorById(@PathVariable Integer idUser, @PathVariable Integer idGrade) {
        GradeProfessorId id = new GradeProfessorId(idUser, idGrade);
        return gradeProfessorService.getGradeProfessorById(id);
    }

    @PostMapping
    public GradeProfessor createGradeProfessor(@RequestBody GradeProfessor gradeProfessor) {
        return gradeProfessorService.saveGradeProfessor(gradeProfessor);
    }

    @DeleteMapping("/{idUser}/{idGrade}")
    public void deleteGradeProfessor(@PathVariable Integer idUser, @PathVariable Integer idGrade) {
        GradeProfessorId id = new GradeProfessorId(idUser, idGrade);
        gradeProfessorService.deleteGradeProfessor(id);
    }
}

