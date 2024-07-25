package com.stage.insertMarks.dto;

public class MarkDTO {
    private Integer idMark;
    private Float markCc;
    private Float markExam;
    private Float markTp;
    private ModuleDTO module;

    // Constructeurs, getters, setters
    public MarkDTO() {}

    public MarkDTO(Integer idMark, Float markCc, Float markExam, Float markTp, ModuleDTO module) {
        this.idMark = idMark;
        this.markCc = markCc;
        this.markExam = markExam;
        this.markTp = markTp;
        this.module = module;
    }

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

    public ModuleDTO getModule() {
        return module;
    }

    public void setModule(ModuleDTO module) {
        this.module = module;
    }
}

