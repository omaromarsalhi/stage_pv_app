package com.stage.insertMarks.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMark;

    @Column(name = "markCc")
    private Float markCc;

    @Column(name = "markExam")
    private Float markExam;

    @Column(name = "markTp")
    private Float markTp;

    @ManyToOne
    @JoinColumn(name = "idModule", nullable = false)
    @JsonIgnore
    private Module module;

    // Getters and setters
    public Integer getIdMark() {
        return idMark;
    }

    public void setIdMark(Integer idMark) {
        this.idMark = idMark;
    }

    public Float getMarkCc() {
        return markCc;
    }

    public void setMarkCc(Float markCc) {
        this.markCc = markCc;
    }

    public Float getMarkExam() {
        return markExam;
    }

    public void setMarkExam(Float markExam) {
        this.markExam = markExam;
    }

    public Float getMarkTp() {
        return markTp;
    }

    public void setMarkTp(Float markTp) {
        this.markTp = markTp;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
