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

    @GetMapping("/send-to-other/{idStudent}/{peName}")
    public ResponseEntity<List<ResponseUe>> sendModulesToOtherService(
            @PathVariable("idStudent") int idStudent,
            @PathVariable("peName") String  peName,
            @RequestHeader("Authorization") String headerValue
    ) {
        return ResponseEntity.ok(
                calculUeService.calculate(
                        peName,
                        idStudent,
                        headerValue)
        );
    }
}