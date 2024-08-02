package com.stage.calcul_Module.modules;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark,Integer> {
    List<Mark> findByIdModule(int idModule);
}
