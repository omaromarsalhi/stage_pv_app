package com.stage.insertMarks.marks;


import com.stage.PV.confing.JwtTokenContextHolder;
import com.stage.PV.generatepv.StudentsRequest;
import com.stage.PV.user.UserResponse;
import com.stage.insertMarks.grade.GradeRepository;
import com.stage.insertMarks.gradeprofessor.GradeProfessor;
import com.stage.insertMarks.gradeprofessor.GradeProfessorRepository;
import com.stage.insertMarks.mark.Mark;
import com.stage.insertMarks.mark.MarkRepository;
import com.stage.insertMarks.module.ModuleRepository;
import com.stage.insertMarks.studentmark.StudentMark;
import com.stage.insertMarks.studentmark.StudentMarkRepository;
import com.stage.insertMarks.user.GetUsers;
import com.stage.insertMarks.user.StudentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MarksService {


    private final GradeProfessorRepository gradeProfessorRepository;
    private final GradeRepository gradeRepository;
    private final MarkRepository markRepository;
    private final ModuleRepository moduleRepository;
    private final StudentMarkRepository studentMarkRepository;
    private GetUsers getUsers;

    public String saveMarks(MarksCredentials marksCredentials) {

        var module = moduleRepository.findByIdModule(marksCredentials.idModule());

        for (Map.Entry<Integer, MarksDto> entry : marksCredentials.marks().entrySet()) {
            Integer userId = entry.getKey();
            MarksDto marks = entry.getValue();

            var mark = Mark
                    .builder()
                    .markCc(marks.cc())
                    .markTp(marks.tp())
                    .markExam(marks.exam())
                    .module(module)
                    .build();

            markRepository.save(
                    mark
            );

            studentMarkRepository.save(
                    StudentMark
                            .builder()
                            .mark(mark)
                            .idStudent(userId)
                            .build()
            );
        }

        return "done";
    }

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


    public List<StudentAndMarkResponse> retrieveStudents(String gradeName, int idModule, String token) {

        JwtTokenContextHolder.setToken(token.substring(7));

        var grade = gradeRepository.findByName(gradeName).orElseThrow(
                () -> new IllegalArgumentException("Invalid grade")
        );

        var students = this.getUsers.getStudents(grade.getIdGrade()).orElseThrow(
                () -> new RuntimeException("No authenticated user found"));

        List<StudentAndMarkResponse> studentResponses = new ArrayList<>();

        students.forEach(student -> {
            var mark = studentMarkRepository.findByIdStudentAndModule(student.idUser(), idModule);
            if (mark == null) {
                mark = Mark.builder()
                        .markCc(0)
                        .markTp(0)
                        .markExam(0)
                        .build();
            }
            studentResponses.add(StudentAndMarkResponse
                    .builder()
                    .student(student)
                    .marks(
                            MarksDto
                                    .builder()
                                    .exam(mark.getMarkExam())
                                    .tp(mark.getMarkTp())
                                    .cc(mark.getMarkCc())
                                    .build()
                    )
                    .build()
            );
        });

        return studentResponses;
    }


}


