package com.stage.calcul_Module.modules;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Marks {

    @Id
    private int idMark;
    private float markCc;
    private float markExam;
    private float markTp;
    private int idModule;

    public int getIdMark() {
        return idMark;
    }

    public void setIdMark(int idMark) {
        this.idMark = idMark;
    }

    public float getMarkCc() {
        return markCc;
    }

    public void setMarkCc(float markCc) {
        this.markCc = markCc;
    }

    public float getMarkExam() {
        return markExam;
    }

    public void setMarkExam(float markExam) {
        this.markExam = markExam;
    }

    public float getMarkTp() {
        return markTp;
    }

    public void setMarkTp(float markTp) {
        this.markTp = markTp;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }
}
