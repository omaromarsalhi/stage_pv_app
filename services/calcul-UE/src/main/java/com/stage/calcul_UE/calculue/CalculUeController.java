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

    @PostMapping("/test")
    public ResponseEntity<String> test(
    ){
        return ResponseEntity.ok("asslamaa");}

    @GetMapping("/by-ue/{idUE}")
    public List<Integer> getModulesByUniteEnseignement(@PathVariable Integer idUE) {
        return calculUeService.getModuleIdsByUniteEnseignement(idUE);
    }

    @PostMapping("/send-to-other/{idUE}/{idStudent}")
    public Map<Integer, Collection<Float>> sendModulesToOtherService(@PathVariable Integer idUE, @PathVariable Integer idStudent) {
        List<Integer> moduleIds = calculUeService.getModuleIdsByUniteEnseignement(idUE);
        return calculUeService.sendModuleIdsToOtherService(moduleIds, idStudent);
    }
}