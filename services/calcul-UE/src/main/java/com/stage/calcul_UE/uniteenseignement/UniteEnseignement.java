package com.stage.calcul_UE.uniteenseignement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UniteEnseignement {
    @Id
    private int idUE;
    private String name;

    public int getIdUE() {
        return idUE;
    }

    public void setIdUE(int idUE) {
        this.idUE = idUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
