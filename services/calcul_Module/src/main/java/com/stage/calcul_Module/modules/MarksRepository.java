package com.stage.calcul_Module.modules;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks,Integer> {
    List<Marks> findByIdModule(int idModule);
}
