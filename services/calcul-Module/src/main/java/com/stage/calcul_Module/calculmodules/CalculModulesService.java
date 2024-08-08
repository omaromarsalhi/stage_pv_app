package com.stage.calcul_Module.calculmodules;

import com.stage.calcul_Module.mark.Mark;
import com.stage.calcul_Module.mark.MarkRepository;
import com.stage.calcul_Module.student.StudentMark;
import com.stage.calcul_Module.student.StudentMarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalculModulesService {

    private final MarkRepository marksRepository;
    private final StudentMarkRepository studentMarkRepository;

    public Map<String, Object> calculateModuleAverage(CalculModulesRequest request) {

        int moduleId = request.idmodule();
        int studentId = request.idstudent();

        var marksIds = studentMarkRepository.findListIds(studentId);

        Mark mark = marksRepository.findMark(marksIds, moduleId);
        double average;
        if (mark == null)
            average = -1;
        else {
            float cc = mark.getMarkCc();
            float exam = mark.getMarkExam();
            float tp = mark.getMarkTp();
            average = (tp == -1) ? ((0.4 * cc) + (0.6 * exam)) : ((0.3 * cc) + (0.2 * tp) + (0.5 * exam));
        }

        Map<String, Object> result = new HashMap<>();
        result.put(Integer.toString(moduleId), average);
        return result;
    }
}
