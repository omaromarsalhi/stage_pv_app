package com.stage.PV.generatepv;


import com.stage.PV.calculatescores.GetScores;
import com.stage.PV.calculatescores.UeResponse;
import com.stage.PV.module.ModuleRepository;
import com.stage.PV.transcript.Transcript;
import com.stage.PV.transcript.TranscriptRepository;
import com.stage.PV.user.GetUsers;
import com.stage.PV.confing.JwtTokenContextHolder;
import com.stage.PV.user.UserResponse;
import com.stage.PV.grade.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GeneratePvService {

    private final GetUsers getUsers;
    private final GetScores getScores;
    private final GradeRepository gradeRepository;
    private final ModuleRepository moduleRepository;
    private final TranscriptRepository transcriptRepository;


    public List<UserResponse> retrieveStudents(StudentsRequest request, String token) {

        JwtTokenContextHolder.setToken(token.substring(7));

        var grade = gradeRepository.findByName(request.grade()).orElseThrow(
                () -> new IllegalArgumentException("Invalid grade")
        );

        return this.getUsers.getStudents(grade.getIdGrade()).orElseThrow(
                () -> new RuntimeException("No authenticated user found"));
    }

    public PvFinalResponse generate(PvRequest request, String headerValue) {
        List<PvResponse> responses = new ArrayList<>();

        var data = getScores(request, headerValue);
        float finalScore = 0;
        float coefSum = 0;

        for (UeResponse subData : data) {
            List<Map<String, Object>> modules = new ArrayList<>();
            for (Map<String, Object> module : subData.scores()) {
                modules.add(formatData(module));
            }
            responses.add(PvResponse
                    .builder()
                    .name(subData.ueName())
                    .nbr_etc(subData.nbrEtc())
                    .moy_ue(subData.average())
                    .module(modules)
                    .build()
            );
            finalScore += subData.average() * subData.nbrEtc();
            coefSum += subData.nbrEtc();
        }

        finalScore = finalScore / coefSum;
        saveTranscript(finalScore, request.grade(), request.idStudent());
        return PvFinalResponse
                .builder()
                .pvResponseList(responses)
                .finalScore(finalScore)
                .result((finalScore >= 10 ? "Admis" : "Refusee"))
                .build();
    }

    private void saveTranscript(float finalScore, String gradeName, int idStudent) {
        var grade = gradeRepository.findByName(gradeName).orElseThrow(
                () -> new IllegalArgumentException("Invalid grade")
        );
        if (!transcriptRepository.existsByIdUser(idStudent)) {
            transcriptRepository.save(
                    Transcript.builder()
                            .averageScore(finalScore)
                            .year(Date.valueOf(LocalDate.now()))
                            .grade(grade)
                            .result((finalScore >= 10 ? "Admis" : "Refusee"))
                            .idUser(idStudent)
                            .build()
            );
        }
    }


    private Map<String, Object> formatData(Map<String, Object> module) {

        Map.Entry<String, Object> firstEntry = module.entrySet().iterator().next();
        String firstKey = firstEntry.getKey();
        double firstValue = (double) firstEntry.getValue();
        var retrivedModule = moduleRepository.findByIdModule(Integer.parseInt(firstKey));

        Map<String, Object> moduleMap = new HashMap<>();
        moduleMap.put("module_name", retrivedModule.getName());
        moduleMap.put("module_coef", retrivedModule.getCoefficient());
        moduleMap.put("module_moy", firstValue);

        return moduleMap;
    }

    private List<UeResponse> getScores(PvRequest request, String token) {
        JwtTokenContextHolder.setToken(token.substring(7));
        return getScores
                .getScores(request.idStudent(), request.peName());
    }
}
