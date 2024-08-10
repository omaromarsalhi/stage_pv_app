package com.stage.insertMarks.marks;


import com.stage.insertMarks.gradeprofessor.GradeProfessor;
import com.stage.insertMarks.gradeprofessor.GradeProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MarksService {


    private final GradeProfessorRepository gradeProfessorRepository;

    public ProfessorResponse retrieveData(int idProfessor) {
        List<ProfessorData> data = new ArrayList<>();
        List<GradeProfessor> professorGrades = gradeProfessorRepository.findAllByIdUser(idProfessor);

        for (GradeProfessor gradeProfessor : professorGrades) {
            data.add(ProfessorData
                    .builder()
                    .gradeName(gradeProfessor.getGrade().getName())
                    .moduleName(gradeProfessor.getModule().getName())
                    .moduleId(gradeProfessor.getModule().getIdModule())
                    .build()
            );
        }

        return ProfessorResponse
                .builder()
                .data(data)
                .build();
    }


}


