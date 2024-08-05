package com.stage.calcul_UE.module;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module,Integer> {

    @Query("""
            select m.idModule from Module m where m.idUE= :idUE order by m.idModule
            """)
    List<Integer> getIdsByIdUE(Integer idUE);

    @Query("""
            select m.coefficient from Module m where m.idUE= :idUE order by m.idModule
            """)
    List<Float> getCoefficientsByIdUE(Integer idUE);
}
