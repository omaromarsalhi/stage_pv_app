package com.stage.calcul_UE.calculue;

import com.stage.calcul_UE.module.Module;
import com.stage.calcul_UE.module.ModuleRepository;
import com.stage.calcul_UE.planetude.PlanEtudeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalculUeService {

    private final ModuleRepository modulesRepository;
    private final RestTemplate restTemplate;
    private final PlanEtudeRepository planEtudeRepository;
    private final String URL = "http://localhost:8888/api/module/calcul";

    public List<ResponseUe> calculate(int idPe, int idStudent, String headerValue) {
        var planEtude = planEtudeRepository.findPlanEtudeByIdPe(idPe);

        List<ResponseUe> list = new ArrayList<>();

        for (Module unity : planEtude.getUnites()) {
            list.add(sendModuleIdsToOtherService(unity.getIdUE(), idStudent, headerValue));
        }
        return list;
    }




    public ResponseUe sendModuleIdsToOtherService(Integer idUE, Integer idStudent, String token) {

        List<Integer> moduleIds = modulesRepository.getIdsByIdUE(idUE);
        List<Float> moduleCoefficients = modulesRepository.getCoefficientsByIdUE(idUE);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Integer> request = new HashMap<>();

        for (Integer idModule : moduleIds) {
            request.put("idmodule", idModule);
            request.put("idstudent", idStudent);

            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                    URL,
                    HttpMethod.POST,
                    new HttpEntity<>(request, headers),
                    (Class<Map<String, Object>>) (Class<?>) Map.class
            );

            Map<String, Object> average = response.getBody();

            list.add(average);
            request.clear();
        }

        var average=calculateAverage(list,moduleIds,moduleCoefficients);

        return ResponseUe
                .builder()
                .idUE(idUE)
                .scores(list)
                .average(average)
                .build();
    }


    private float calculateAverage(List<Map<String, Object>> list,List<Integer> moduleIds,List<Float> moduleCoefficients) {
        float sum = 0;
        float coefficients = 0;
        for (int i = 0; i < list.size(); i++) {
            sum+=(Double) list.get(i).get(Integer.toString(moduleIds.get(i))) * moduleCoefficients.get(i);
            coefficients+=moduleCoefficients.get(i);
        }
        return sum/coefficients;
    }

}
