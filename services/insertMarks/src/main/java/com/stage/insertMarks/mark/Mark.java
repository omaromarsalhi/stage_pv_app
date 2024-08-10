package com.stage.insertMarks.mark;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mark {

    @Id
    private int idMark;
    private float markCc;
    private float markExam;
    private float markTp;
    private int idModule;

}
