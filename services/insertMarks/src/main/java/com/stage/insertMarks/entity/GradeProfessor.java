package com.stage.insertMarks.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "GradeProfessor")
@IdClass(GradeProfessorId.class)
public class GradeProfessor {
    @Id
    @Column(name = "idUser")
    private Integer idUser;

    @Id
    @Column(name = "idGrade")
    private Integer idGrade;

    // Getters and setters
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }
}
