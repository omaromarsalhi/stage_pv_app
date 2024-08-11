package com.stage.insertMarks.studentmark;


import com.stage.insertMarks.mark.Mark;
import com.stage.insertMarks.module.Module;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentMark {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentmark_seq")
    @SequenceGenerator(name = "studentmark_seq", sequenceName = "studentmark_SEQ", allocationSize = 1)
    @Column(name = "idStudentMark")
    private Integer idStudentMark;

    @ManyToOne
    @JoinColumn(name = "idMark")
    private Mark mark;

    private int idStudent;

}
