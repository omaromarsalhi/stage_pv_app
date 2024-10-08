package com.stage.PV.grade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

    Optional<Grade> findByName(String name);

    @Query("""
            SELECT g from Grade g where g.name like :levelName
            """)
    List<Grade> findByLevel(String levelName);
}
