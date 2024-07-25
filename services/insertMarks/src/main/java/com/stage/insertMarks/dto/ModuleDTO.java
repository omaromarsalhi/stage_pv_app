package com.stage.insertMarks.dto;

public class ModuleDTO {
    private Integer idModule;
    private String name;
    private Float coefficient;

    // Constructeurs, getters, setters
    public ModuleDTO() {}

    public ModuleDTO(Integer idModule, String name, Float coefficient) {
        this.idModule = idModule;
        this.name = name;
        this.coefficient = coefficient;
    }

    public Integer getIdModule() {
        return idModule;
    }

    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }
}

