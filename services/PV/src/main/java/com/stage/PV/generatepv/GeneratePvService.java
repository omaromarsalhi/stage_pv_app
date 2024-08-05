package com.stage.PV.generatepv;


import com.stage.PV.calculatescores.GetScores;
import com.stage.PV.calculatescores.UeResponse;
import com.stage.PV.user.GetUsers;
import com.stage.PV.confing.JwtTokenContextHolder;
import com.stage.PV.user.UserResponse;
import com.stage.PV.grade.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneratePvService {

    private final GetUsers getUsers;
    private final GetScores getScores;
    private final GradeRepository gradeRepository;


    public List<UserResponse> retrieveStudents(StudentsRequest request, String token) {

        JwtTokenContextHolder.setToken(token.substring(7));

        var grade = gradeRepository.findByName(request.grade()).orElseThrow(
                () -> new IllegalArgumentException("Invalid grade")
        );

        return this.getUsers.getStudents(grade.getIdGrade()).orElseThrow(
                () -> new RuntimeException("No authenticated user found"));
    }

    public PvResponse generate(PvRequest request, String headerValue) {
        System.out.println(getScores(request, headerValue));
        return PvResponse.builder().build();
    }

    private UeResponse getScores(PvRequest request, String token) {
        JwtTokenContextHolder.setToken(token.substring(7));
        return getScores
                .getScores(request.idStudent(), request.idPe())
                .orElseThrow(()->new RuntimeException("error has occurred"));
    }
}
