package com.stage.insertMarks.planetude;

import com.stage.insertMarks.uniteenseignement.UniteEnseignement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanEtude {

    @Id
    Integer idPe;

    String name;

    int level;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "planetudeuniteenseignement",
            joinColumns = @JoinColumn(name = "idPe"),
            inverseJoinColumns = @JoinColumn(name = "idUe")
    )
    private Set<UniteEnseignement> unites = new HashSet<>();
}
