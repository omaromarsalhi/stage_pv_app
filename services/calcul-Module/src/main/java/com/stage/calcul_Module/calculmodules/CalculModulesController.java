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
            @RequestBody ModuleMarksRequest request
    ){
        return ResponseEntity.ok(calculModulesService.calculateModuleAverage(request));}
    @PostMapping("/test")
    public ResponseEntity<String> averages(
    ){
        return ResponseEntity.ok("asslamaa");}
}
