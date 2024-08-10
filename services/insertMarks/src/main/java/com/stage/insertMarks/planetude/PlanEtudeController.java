package com.stage.insertMarks.planetude;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/insertMarks/planetude")
@AllArgsConstructor
public class PlanEtudeController {

    private final PlanEtudeService planEtudeService;

    @PostMapping
    public ResponseEntity<List<PlanEtude>> getPlanEtude() {
        return ResponseEntity.ok(planEtudeService.getPlanEtude());
    }

}
