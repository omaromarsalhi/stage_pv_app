package com.stage.calcul_Module.calculmodules;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/module")
public class CalculModulesController {
    private final CalculModulesService calculModulesService;


    @PostMapping("/calcul")
    public ResponseEntity<Map<Integer, Float>> averages(
            @RequestBody CalculModulesRequest request
    ){
        return ResponseEntity.ok(calculModulesService.calculateModuleAverage(request));}
}
