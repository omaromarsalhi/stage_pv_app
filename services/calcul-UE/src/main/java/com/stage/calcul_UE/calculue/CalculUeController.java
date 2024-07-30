package com.stage.calcul_UE.calculue;

import com.stage.calcul_UE.uniteenseignement.UniteEnseignementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ue")
public class CalculUeController {
    private final CalculUeService calculUeService;

    @PostMapping("/test")
    public ResponseEntity<String> test(
    ){
        return ResponseEntity.ok("asslamaa");}

    @GetMapping("/by-ue/{idUE}")
    public List<Integer> getModulesByUniteEnseignement(@PathVariable Integer idUE) {
        return calculUeService.getModuleIdsByUniteEnseignement(idUE);
    }

}