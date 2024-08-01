package com.stage.insertMarks.entity;

import java.io.Serializable;
import java.util.Objects;

public class GradeProfessorId implements Serializable {
    private Integer idUser;
    private Integer idGrade;

    public GradeProfessorId() {}

    public GradeProfessorId(Integer idUser, Integer idGrade) {
        this.idUser = idUser;
        this.idGrade = idGrade;
    }

    // Getters, setters, equals, and hashCode methods
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeProfessorId that = (GradeProfessorId) o;
        return Objects.equals(idUser, that.idUser) && Objects.equals(idGrade, that.idGrade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idGrade);
    }
}

