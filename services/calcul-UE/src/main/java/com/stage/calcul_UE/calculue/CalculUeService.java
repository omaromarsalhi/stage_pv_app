package com.stage.calcul_UE.calculue;

import com.stage.calcul_UE.uniteenseignement.Module;
import com.stage.calcul_UE.uniteenseignement.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalculUeService {
    private final ModuleRepository modulesRepository;

    public List<Integer> getModuleIdsByUniteEnseignement(Integer idUE) {
        List<Module> modules = modulesRepository.findByIdUE(idUE);
        return modules.stream()
                .map(Module::getIdModule)
                .collect(Collectors.toList());
    }

}
