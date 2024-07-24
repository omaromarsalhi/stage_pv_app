package com.stage.insertMarks.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "UniteEnseignement")
public class UniteEnseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUE;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "uniteEnseignement", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AcademicModule> academicModules;

    // Getters and setters
    public Long getIdUE() {
        return idUE;
    }

    public void setIdUE(Long idUE) {
        this.idUE = idUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AcademicModule> getModules() {
        return academicModules;
    }

    public void setModules(Set<AcademicModule> academicModules) {
        this.academicModules = academicModules;
    }
}


