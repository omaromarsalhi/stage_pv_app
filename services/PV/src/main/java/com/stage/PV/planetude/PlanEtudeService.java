package com.stage.PV.planetude;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class PlanEtudeService {

    private final PlanEtudeRepository planEtudeRepository;

    public List<PlanEtude> getPlanEtude() {
        return planEtudeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(PlanEtude::getLevel))
                .toList();
    }
}
