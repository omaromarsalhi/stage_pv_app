package com.stage.insertMarks.repository;

import com.stage.insertMarks.entity.GradeProfessor;
import com.stage.insertMarks.entity.GradeProfessorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeProfessorRepository extends JpaRepository<GradeProfessor, GradeProfessorId> {
}
