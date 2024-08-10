package com.stage.insertMarks.student;

import com.stage.insertMarks.mark.Mark;
import com.stage.insertMarks.mark.MarkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentMarkService {

    private final StudentMarkRepository studentMarkRepository;
    private final MarkRepository markRepository;

    public StudentMarkService(StudentMarkRepository studentMarkRepository, MarkRepository markRepository) {
        this.studentMarkRepository = studentMarkRepository;
        this.markRepository = markRepository;
    }

    @Transactional
    public void insertStudentMark(int studentId, int moduleId, float markCc, float markExam, float markTp) {
        // Créer et enregistrer une nouvelle Mark
        Mark mark = new Mark();
        mark.setIdModule(moduleId);
        mark.setMarkCc(markCc);
        mark.setMarkExam(markExam);
        mark.setMarkTp(markTp);
        markRepository.save(mark);

        // Associer la Mark à l'étudiant
        StudentMark studentMark = new StudentMark();
        studentMark.setIdstudent(studentId);
        studentMark.setIdmark(mark.getIdMark());
        studentMarkRepository.save(studentMark);
    }

    public List<StudentMark> getStudentMarks(int studentId) {
        return studentMarkRepository.findByIdstudent(studentId);
    }
}
