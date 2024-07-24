package com.stage.insertMarks.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "academicModules")
public class AcademicModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModule;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "coefficient", nullable = false)
    private float coefficient;

    @ManyToOne
    @JoinColumn(name = "idUE", nullable = false)
    private UniteEnseignement uniteEnseignement;

    @OneToMany(mappedBy = "academicModule", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Mark> marks;

    // Getters and setters
    public Long getIdModule() {
        return idModule;
    }

    public void setIdModule(Long idModule) {
        this.idModule = idModule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public UniteEnseignement getUniteEnseignement() {
        return uniteEnseignement;
    }

    public void setUniteEnseignement(UniteEnseignement uniteEnseignement) {
        this.uniteEnseignement = uniteEnseignement;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }
}
