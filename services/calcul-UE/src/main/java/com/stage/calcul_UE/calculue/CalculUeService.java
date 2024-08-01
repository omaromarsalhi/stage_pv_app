package com.stage.calcul_UE.calculue;

import com.stage.calcul_UE.uniteenseignement.Module;
import com.stage.calcul_UE.uniteenseignement.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalculUeService {
    private final ModuleRepository modulesRepository;
    private final RestTemplate restTemplate;

    public List<Integer> getModuleIdsByUniteEnseignement(Integer idUE) {
        List<Module> modules = modulesRepository.findByIdUE(idUE);
        return modules.stream()
                .map(Module::getIdModule)
                .collect(Collectors.toList());
    }
    public Map<Integer, Collection<Float>> sendModuleIdsToOtherService(List<Integer> moduleIds, Integer idStudent) {
        String url = "http://localhost:8888/CALCUL-MODULE/api/module/calcul";

        Map<Integer, Collection<Float>> moduleAverages = new HashMap<>();

        for (Integer idModule : moduleIds) {
            Map<String, Integer> request = new HashMap<>();
            request.put("idmodule", idModule);
            request.put("idstudent", idStudent);

            Map<Integer, Float> response = restTemplate.postForObject(
                    url,
                    request,
                    Map.class
            );
            Collection<Float> average = response.values();
            moduleAverages.put(idModule, average);
        }

        return moduleAverages;
    }

}
