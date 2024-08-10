package com.stage.insertMarks.gradeprofessor;


import com.stage.insertMarks.grade.Grade;
import com.stage.insertMarks.module.Module;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeProfessor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gradeprofessor_seq")
    @SequenceGenerator(name = "gradeprofessor_seq", sequenceName = "gradeprofessor_SEQ", allocationSize = 1)
    @Column(name = "idGradeProfessor")
    private Integer idGradeProfessor;

    private int idUser;

    @OneToOne
    @JoinColumn(name = "idGrade")
    private Grade grade;

    @OneToOne
    @JoinColumn(name = "idModule")
    private Module module;

}
