package com.stage.calcul_UE.planetude;


import com.stage.calcul_UE.module.Module;
import com.stage.calcul_UE.uniteenseignement.UniteEnseignement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
