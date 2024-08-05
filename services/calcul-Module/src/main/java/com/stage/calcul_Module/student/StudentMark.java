package com.stage.calcul_Module.student;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentMark {
    @Id
    private int idstudent;
    private int idmark;

    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    public int getIdmark() {
        return idmark;
    }

    public void setIdmark(int idmark) {
        this.idmark = idmark;
    }
}
