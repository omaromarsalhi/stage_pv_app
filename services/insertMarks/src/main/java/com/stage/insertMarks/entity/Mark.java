package com.stage.insertMarks.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMark;

    @Column(name = "markCc")
    private Float markCc;

    @Column(name = "markExam")
    private Float markExam;

    @Column(name = "markTp")
    private Float markTp;

    @ManyToOne
    @JoinColumn(name = "idModule", nullable = false)
    private AcademicModule academicModule;

    // Getters and setters
    public Long getIdMark() {
        return idMark;
    }

    public void setIdMark(Long idMark) {
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

    public AcademicModule getAcademicModule() {
        return academicModule;
    }

    public void setAcademicModule(AcademicModule academicModule) {
        this.academicModule = academicModule;
    }
}
