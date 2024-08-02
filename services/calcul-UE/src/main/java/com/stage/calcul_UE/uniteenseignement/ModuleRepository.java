package com.stage.calcul_UE.uniteenseignement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module,Integer> {
    List<Module> findByIdUE(Integer idUE);
}
