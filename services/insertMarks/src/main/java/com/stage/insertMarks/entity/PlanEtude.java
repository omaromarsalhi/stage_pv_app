package com.stage.insertMarks.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "planEtude")
public class PlanEtude {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPE;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "level", nullable = false)
    private String level;

    @OneToMany(mappedBy = "planEtude", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Grade> grades;

    // Getters and Setters
    public Long getIdPE() {
        return idPE;
    }

    public void setIdPE(Long idPE) {
        this.idPE = idPE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }
}
