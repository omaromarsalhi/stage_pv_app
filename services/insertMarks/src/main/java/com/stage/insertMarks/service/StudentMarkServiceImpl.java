package com.stage.insertMarks.service;

import com.stage.insertMarks.entity.Mark;
import com.stage.insertMarks.entity.StudentMark;
import com.stage.insertMarks.repository.StudentMarkRepository;
import com.stage.insertMarks.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMarkServiceImpl implements StudentMarkService {

    private final StudentMarkRepository studentMarkRepository;
    private final MarkRepository markRepository;

    @Autowired
    public StudentMarkServiceImpl(StudentMarkRepository studentMarkRepository, MarkRepository markRepository) {
        this.studentMarkRepository = studentMarkRepository;
        this.markRepository = markRepository;
    }

    @Override
    public StudentMark saveStudentMark(StudentMark studentMark) {
        Mark mark = studentMark.getMark();

        // Ensure the Mark entity exists in the database
        final Mark finalMark;
        if (mark.getIdMark() != null) {
            finalMark = markRepository.findById(mark.getIdMark())
                    .orElseThrow(() -> new IllegalArgumentException("Mark not found for ID: " + mark.getIdMark()));
        } else {
            finalMark = markRepository.save(mark);
        }

        studentMark.setMark(finalMark);
        return studentMarkRepository.save(studentMark);
    }

    @Override
    public List<StudentMark> getAllStudentMarks() {
        return studentMarkRepository.findAll();
    }

    @Override
    public void deleteStudentMark(Integer studentId, Integer markId) {
        StudentMarkId id = new StudentMarkId(studentId, markId);
        studentMarkRepository.deleteById(id);
    }
}
