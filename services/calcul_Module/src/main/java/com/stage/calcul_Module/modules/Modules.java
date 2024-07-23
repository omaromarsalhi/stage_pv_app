package com.stage.calcul_Module.modules;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Modules {
    @Id
    private int idModule;
    private String name;
    private float coefficient;
    private int idUE;

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
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

    public int getIdUE() {
        return idUE;
    }

    public void setIdUE(int idUE) {
        this.idUE = idUE;
    }
}
