package com.stage.insertMarks.grade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class GradeService {

    private GradeRepository gradeRepository;

    public List<Grade> getAllGrades(String level) {
        String levelName = level + "%";
        return gradeRepository.findByLevel(levelName)
                .stream()
                .sorted(Comparator.comparing(Grade::getIdGrade))
                .toList();
    }
}
