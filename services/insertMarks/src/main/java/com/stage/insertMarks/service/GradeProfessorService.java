package com.stage.insertMarks.service;

import com.stage.insertMarks.entity.GradeProfessor;
import com.stage.insertMarks.entity.GradeProfessorId;
import com.stage.insertMarks.repository.GradeProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeProfessorService {
    @Autowired
    private GradeProfessorRepository gradeProfessorRepository;

    public List<GradeProfessor> getAllGradeProfessors() {
        return gradeProfessorRepository.findAll();
    }

    public GradeProfessor getGradeProfessorById(GradeProfessorId id) {
        return gradeProfessorRepository.findById(id).orElse(null);
    }

    public GradeProfessor saveGradeProfessor(GradeProfessor gradeProfessor) {
        return gradeProfessorRepository.save(gradeProfessor);
    }

    public void deleteGradeProfessor(GradeProfessorId id) {
        gradeProfessorRepository.deleteById(id);
    }
}

