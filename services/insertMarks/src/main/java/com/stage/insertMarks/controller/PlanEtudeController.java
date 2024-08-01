package com.stage.insertMarks.controller;

import com.stage.insertMarks.entity.PlanEtude;
import com.stage.insertMarks.service.PlanEtudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planEtudes")
public class PlanEtudeController {

    @Autowired
    private PlanEtudeService planEtudeService;

    @GetMapping
    public List<PlanEtude> getAllPlanEtudes() {
        return planEtudeService.getAllPlanEtudes();
    }

    @GetMapping("/{idPE}")
    public ResponseEntity<PlanEtude> getPlanEtudeById(@PathVariable Long idPE) {
        Optional<PlanEtude> planEtude = planEtudeService.getPlanEtudeById(idPE);
        if (planEtude.isPresent()) {
            return ResponseEntity.ok(planEtude.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PlanEtude createPlanEtude(@RequestBody PlanEtude planEtude) {
        return planEtudeService.savePlanEtude(planEtude);
    }

    @DeleteMapping("/{idPE}")
    public ResponseEntity<Void> deletePlanEtude(@PathVariable Long idPE) {
        planEtudeService.deletePlanEtude(idPE);
        return ResponseEntity.noContent().build();
    }
}

