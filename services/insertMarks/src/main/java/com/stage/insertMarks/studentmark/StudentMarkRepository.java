package com.stage.insertMarks.studentmark;

import com.stage.insertMarks.mark.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentMarkRepository extends JpaRepository<StudentMark, Integer> {


    @Query("""
            select studentmark.mark from StudentMark studentmark 
            where studentmark.idStudent=?1 and studentmark.mark.module.idModule= ?2
            """)
    Mark findByIdStudentAndModule(int id, int idModule);
}
