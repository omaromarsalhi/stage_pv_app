package com.stage.insertMarks.repository;

import com.stage.insertMarks.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}

