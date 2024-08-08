package com.stage.PV.transcript;


import com.stage.PV.grade.Grade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transcript_seq")
    @SequenceGenerator(name = "transcript_seq", sequenceName = "transcript_SEQ", allocationSize = 1)
    @Column(name = "idTranscript")
    private Integer idTranscript;

    private float averageScore;

    private Date year;

    private String result;

    @ManyToOne
    @JoinColumn(name = "idGrade")
    private Grade grade;

    private int idUser;
}
