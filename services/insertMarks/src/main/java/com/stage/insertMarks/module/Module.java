package com.stage.insertMarks.module;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {


    @Id
    private int idModule;
    private String name;
    private float coefficient;
    private int idUE;
}
