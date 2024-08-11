package com.stage.calcul_Module.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentMarkRepository extends JpaRepository<StudentMark, Integer> {


    @Query("""
                    select s.idmark from StudentMark s where s.idstudent =?1
            """)
    List<Integer> findListIds(int idstudent);
}
