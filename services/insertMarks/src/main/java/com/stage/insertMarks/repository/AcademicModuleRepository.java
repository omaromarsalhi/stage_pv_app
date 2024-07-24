package com.stage.insertMarks.repository;

import com.stage.insertMarks.entity.AcademicModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicModuleRepository extends JpaRepository<AcademicModule, Long> {
}
