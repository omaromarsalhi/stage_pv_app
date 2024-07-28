package com.stage.PV.grade;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class GradeService {

    private GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Grade::getIdGrade))
                .toList();
    }
}
