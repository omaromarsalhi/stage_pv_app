package com.stage.calcul_Module.modules;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentMarkRepository extends JpaRepository<StudentMark,Integer> {
    List<StudentMark> findByIdstudent(int idstudent);
}
