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
@CrossOrigin(origins = "http://localhost:3000/")
public class PlanEtudeController {

    @Autowired
    private PlanEtudeService planEtudeService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping
    public List<PlanEtude> getAllPlanEtudes() {
        return planEtudeService.getAllPlanEtudes();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/{idPE}")
    public ResponseEntity<PlanEtude> getPlanEtudeById(@PathVariable Integer idPE) {
        Optional<PlanEtude> planEtude = planEtudeService.getPlanEtudeById(idPE);
        if (planEtude.isPresent()) {
            return ResponseEntity.ok(planEtude.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping
    public PlanEtude createPlanEtude(@RequestBody PlanEtude planEtude) {
        return planEtudeService.savePlanEtude(planEtude);
    }

    @DeleteMapping("/{idPE}")
    public ResponseEntity<Void> deletePlanEtude(@PathVariable Integer idPE) {
        planEtudeService.deletePlanEtude(idPE);
        return ResponseEntity.noContent().build();
    }
}

