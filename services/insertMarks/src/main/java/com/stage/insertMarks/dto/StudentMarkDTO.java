package com.stage.insertMarks.dto;


public class StudentMarkDTO {
    private Integer studentId;
    private Integer markId;
    private MarkDTO mark;

    // Constructeurs, getters, setters
    public StudentMarkDTO() {}

    public StudentMarkDTO(Integer studentId, Integer markId, MarkDTO mark) {
        this.studentId = studentId;
        this.markId = markId;
        this.mark = mark;
    }

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

    public MarkDTO getMark() {
        return mark;
    }

    public void setMark(MarkDTO mark) {
        this.mark = mark;
    }
}

