package com.stage.calcul_UE.calculue;

import com.stage.calcul_UE.uniteenseignement.UniteEnseignementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ue")
public class CalculUeController {
    private final CalculUeService calculUeService;

    @PostMapping("/send-to-other")
    public Map<Integer, Collection<Float>> sendModulesToOtherService(
            @RequestBody CalculUeRequest request,
            @RequestHeader("Authorization") String headerValue
            ) {
        return calculUeService.sendModuleIdsToOtherService(request.idUE(), request.idstudent(),headerValue);
    }
}