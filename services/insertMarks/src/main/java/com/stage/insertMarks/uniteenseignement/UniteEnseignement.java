package com.stage.insertMarks.uniteenseignement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniteEnseignement {
    @Id
    private int idUE;
    private String name;

}
