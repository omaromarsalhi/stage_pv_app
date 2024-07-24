package com.stage.calcul_Module.calculmodules;

import com.stage.calcul_Module.modules.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalculModulesService {
    private final ModulesRepository modulesRepository;
    private final MarksRepository marksRepository;
    private final StudentMarkRepository studentMarkRepository;

    public Map<String, Object> calculateModuleAverage(ModuleMarksRequest request) {

        int moduleId = request.idmodule();
        int studentId = request.idstudent();

        List<StudentMark> studentMarksList = studentMarkRepository.findByIdstudent(studentId);

        List<Integer> marksIds = studentMarksList.stream()
                .map(StudentMark::getIdmark)
                .collect(Collectors.toList());

        List<Marks> marksList = marksRepository.findAllById(marksIds).stream()
                .filter(mark -> mark.getIdModule() == moduleId)
                .collect(Collectors.toList());

        double average = marksList.stream()
                .mapToDouble(mark -> {
                    float cc = mark.getMarkCc();
                    float exam = mark.getMarkExam();
                    float tp = mark.getMarkTp();

                    if (tp <= 0) {
                        return (0.4 * cc) + (0.6 * exam);
                    } else {
                        return (0.3 * cc) + (0.2 * tp) + (0.5 * exam);
                    }
                })
                .average()
                .orElse(0.0);

        Map<String, Object> result = new HashMap<>();
        result.put("average", average);

        return result;
    }
}
