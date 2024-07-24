package com.stage.calcul_Module.calculmodules;

import com.stage.calcul_Module.modules.Marks;
import com.stage.calcul_Module.modules.MarksRepository;
import com.stage.calcul_Module.modules.Modules;
import com.stage.calcul_Module.modules.ModulesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class CalculModulesController {
    private final CalculModulesService calculModulesService;
    @PostMapping("/averages")
    public ResponseEntity<Map<String, Object>> averages(
            @RequestBody ModuleMarksRequest request
    ){
        Map<String, Object> result = calculModulesService.calculateModuleAverage(request);
        return ResponseEntity.ok(result);    }
}
