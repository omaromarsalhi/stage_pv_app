package com.stage.insertMarks.repository;

import com.stage.insertMarks.entity.StudentMark;
import com.stage.insertMarks.service.StudentMarkId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentMarkRepository extends JpaRepository<StudentMark, StudentMarkId> {
}
