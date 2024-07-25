package com.stage.insertMarks.service;

import com.stage.insertMarks.entity.StudentMark;
import com.stage.insertMarks.repository.StudentMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMarkServiceImpl implements StudentMarkService {

    @Autowired
    private StudentMarkRepository studentMarkRepository;

    @Override
    public StudentMark saveStudentMark(StudentMark studentMark) {
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
