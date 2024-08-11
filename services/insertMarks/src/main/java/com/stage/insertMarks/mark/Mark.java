package com.stage.insertMarks.mark;


import com.stage.insertMarks.module.Module;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mark_seq")
    @SequenceGenerator(name = "mark_seq", sequenceName = "mark_SEQ", allocationSize = 1)
    @Column(name = "idMark")
    private Integer idMark;

    private float markCc;

    private float markExam;

    private float markTp;

    @ManyToOne
    @JoinColumn(name = "idModule")
    private Module module;

}
