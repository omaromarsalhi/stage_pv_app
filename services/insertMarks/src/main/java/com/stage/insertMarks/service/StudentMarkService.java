package com.stage.insertMarks.service;

import com.stage.insertMarks.entity.StudentMark;

import java.util.List;

public interface StudentMarkService {
    StudentMark saveStudentMark(StudentMark studentMark);
    List<StudentMark> getAllStudentMarks();
    void deleteStudentMark(Integer studentId, Integer markId);
}

