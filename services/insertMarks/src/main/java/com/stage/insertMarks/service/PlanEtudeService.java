package com.stage.insertMarks.service;

import com.stage.insertMarks.entity.PlanEtude;
import com.stage.insertMarks.repository.PlanEtudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanEtudeService {

    @Autowired
    private PlanEtudeRepository planEtudeRepository;

    public List<PlanEtude> getAllPlanEtudes() {
        return planEtudeRepository.findAll();
    }

    public Optional<PlanEtude> getPlanEtudeById(Long idPE) {
        return planEtudeRepository.findById(idPE);
    }

    public PlanEtude savePlanEtude(PlanEtude planEtude) {
        return planEtudeRepository.save(planEtude);
    }

    public void deletePlanEtude(Long idPE) {
        planEtudeRepository.deleteById(idPE);
    }
}

