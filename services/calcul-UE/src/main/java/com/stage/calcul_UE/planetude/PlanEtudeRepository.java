package com.stage.calcul_UE.planetude;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlanEtudeRepository extends JpaRepository<PlanEtude, Integer> {


    @Query("""
            select pe.idPe from PlanEtude pe where pe.name = ?1
            """)
    int findIdPlanEtudeByName(String peName);

    PlanEtude findPlanEtudesByIdPe(int idPe);
}
