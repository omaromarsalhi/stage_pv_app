package com.stage.insertMarks.gradeprofessor;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeProfessorRepository extends JpaRepository<GradeProfessor, Integer> {

    List<GradeProfessor> findAllByIdUser(int idProfessor);

}
