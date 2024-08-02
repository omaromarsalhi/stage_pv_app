package com.stage.insertMarks.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGrade;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "idPE")
    private PlanEtude planEtude;

    // Getters and setters
    public Integer getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlanEtude getPlanEtude() {
        return planEtude;
    }

    public void setPlanEtude(PlanEtude planEtude) {
        this.planEtude = planEtude;
    }
}
