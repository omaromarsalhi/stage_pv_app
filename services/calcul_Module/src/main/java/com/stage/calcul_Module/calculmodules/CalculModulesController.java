package com.stage.calcul_Module.calculmodules;

import com.stage.calcul_Module.modules.ModulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class CalculModulesController {
    @Autowired
    private ModulesRepository modulesRepository;
}
