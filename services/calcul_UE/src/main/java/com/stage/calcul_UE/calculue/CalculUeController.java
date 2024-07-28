package com.stage.calcul_UE.calculue;

import com.stage.calcul_UE.uniteenseignement.UniteEnseignementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculUeController {
    @Autowired
    private UniteEnseignementRepository ueRepository;
}
