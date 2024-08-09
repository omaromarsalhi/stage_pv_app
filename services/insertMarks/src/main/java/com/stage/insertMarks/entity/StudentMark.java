package com.stage.insertMarks.entity;

import com.stage.insertMarks.service.StudentMarkId;
import jakarta.persistence.*;

@Entity
@Table(name = "studentMark")
@IdClass(StudentMarkId.class)
public class StudentMark {

    @Id
    @Column(name = "idStudent")
    private Integer studentId;

    @Id
    @Column(name = "idMark")
    private Integer markId;

    @ManyToOne
    @JoinColumn(name = "idStudent", insertable = false, updatable = false)
    private User user; // Représente l'étudiant

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idMark", insertable = false, updatable = false)
    private Mark mark;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
}
