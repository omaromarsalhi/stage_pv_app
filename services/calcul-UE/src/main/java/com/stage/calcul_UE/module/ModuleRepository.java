package com.stage.calcul_UE.module;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module,Integer> {

    @Query("""
            select distinct m.idModule from Module m where m.idUE= :idUE
            """)
    List<Integer> getIdsByIdUE(Integer idUE);

    @Query("""
            select distinct m.coefficient from Module m where m.idUE= :idUE
            """)
    List<Float> getCoefficientsByIdUE(Integer idUE);
}
