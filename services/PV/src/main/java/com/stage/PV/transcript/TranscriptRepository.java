package com.stage.PV.transcript;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscriptRepository extends JpaRepository<Transcript, Integer> {


    boolean existsByIdUser(int id);
}
