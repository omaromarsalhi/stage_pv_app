package com.stage.calcul_UE.calculue;

import com.stage.calcul_UE.uniteenseignement.Module;
import com.stage.calcul_UE.uniteenseignement.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

    public Map<Integer, Collection<Float>> sendModuleIdsToOtherService(Integer idUE, Integer idStudent,String token) {
        List<Module> modules = modulesRepository.findByIdUE(idUE);
        List<Integer> moduleIds = modules.stream()
                .map(Module::getIdModule)
                .collect(Collectors.toList());


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+token);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "http://localhost:8888/api/module/calcul";

        Map<Integer, Collection<Float>> moduleAverages = new HashMap<>();

        for (Integer idModule : moduleIds) {
            Map<String, Integer> request = new HashMap<>();
            request.put("idmodule", idModule);
            request.put("idstudent", idStudent);

//            Map<Integer, Float> response = restTemplate.postForObject(
//                    url,
//                    request,
//                    Map.class,
//            );
            ResponseEntity<Map<Integer, Float>> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    (Class<Map<Integer, Float>>) (Class<?>) Map.class
            );
//            Collection<Float> average = response.values();
//            moduleAverages.put(idModule, average);
            Collection<Float> average = response.getBody().values();
            moduleAverages.put(idModule, average);
        }

        return moduleAverages;
    }

}
