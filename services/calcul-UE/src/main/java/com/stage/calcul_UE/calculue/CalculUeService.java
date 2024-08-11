package com.stage.calcul_UE.calculue;

import com.stage.calcul_UE.module.Module;
import com.stage.calcul_UE.module.ModuleRepository;
import com.stage.calcul_UE.planetude.PlanEtudeRepository;
import com.stage.calcul_UE.uniteenseignement.UniteEnseignement;
import com.stage.calcul_UE.uniteenseignement.UniteEnseignementRepository;
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
    private final UniteEnseignementRepository uniteEnseignementRepository;

    public List<ResponseUe> calculate(String  peName, int idStudent, String headerValue) {
        var idPe=planEtudeRepository.findIdPlanEtudeByName(peName);
        var units = planEtudeRepository
                .findPlanEtudesByIdPe(idPe)
                .getUnites()
                .stream()
                .sorted(Comparator.comparing(UniteEnseignement::getIdUE))
                .toList();

        List<ResponseUe> list = new ArrayList<>();

        for (UniteEnseignement unit : units) {
            list.add(sendModuleIdsToOtherService(unit.getIdUE(), idStudent, headerValue));
        }
        return list;
    }


    public ResponseUe sendModuleIdsToOtherService(int idUE, Integer idStudent, String token) {


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


        double sumCoef = moduleCoefficients.stream()
                .mapToDouble(Float::doubleValue)
                .sum();
        var average = calculateAverage(list, moduleIds, moduleCoefficients, sumCoef);
        var ueName= uniteEnseignementRepository.findById(idUE).get().getName();

        return ResponseUe
                .builder()
                .idUE(idUE)
                .scores(list)
                .average(average)
                .nbrEtc((float) sumCoef)
                .ueName(ueName)
                .build();
    }


    private float calculateAverage(List<Map<String, Object>> list, List<Integer> moduleIds, List<Float> moduleCoefficients, double sumCoef) {
        float sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += (Double) list.get(i).get(Integer.toString(moduleIds.get(i))) * moduleCoefficients.get(i);
        }
        return (float) (sum / sumCoef);
    }

}
