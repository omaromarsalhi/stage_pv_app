package com.stage.insertMarks.service;

import java.io.Serializable;
import java.util.Objects;

public class StudentMarkId implements Serializable {
    private Integer studentId;
    private Integer markId;

    // Default constructor
    public StudentMarkId() {}

    public StudentMarkId(Integer studentId, Integer markId) {
        this.studentId = studentId;
        this.markId = markId;
    }

    // Getters and setters
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentMarkId that = (StudentMarkId) o;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(markId, that.markId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, markId);
    }
}
