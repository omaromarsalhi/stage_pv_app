package com.stage.insertMarks.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "UniteEnseignement")
public class UniteEnseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUE;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "uniteEnseignement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Module> module;

    // Getters and setters
    public Integer getIdUE() {
        return idUE;
    }

    public void setIdUE(Integer idUE) {
        this.idUE = idUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Module> getModule() {
        return module;
    }

    public void setModule(Set<Module> module) {
        this.module = module;
    }
}


