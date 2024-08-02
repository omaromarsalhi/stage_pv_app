package com.stage.calcul_UE.planetude;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanEtudeRepository extends JpaRepository<PlanEtude, Integer> {

    PlanEtude findPlanEtudeByIdPe(Integer planEtudeId);
}
