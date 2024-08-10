package com.stage.insertMarks.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentMarkRepository extends JpaRepository<StudentMark, Integer> {

    @Query("SELECT s FROM StudentMark s WHERE s.idstudent = ?1")
    List<StudentMark> findByIdstudent(int idstudent);
    @Query("""
                    select s.idmark from StudentMark s where s.idstudent =?1
            """)
    List<Integer> findListIds(int idstudent);
}
