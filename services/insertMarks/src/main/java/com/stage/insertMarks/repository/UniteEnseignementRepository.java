package com.stage.insertMarks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stage.insertMarks.entity.UniteEnseignement;

@Repository
public interface UniteEnseignementRepository extends JpaRepository<UniteEnseignement, Integer> {
}

