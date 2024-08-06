package com.stage.calcul_UE.calculue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@Builder
public record ResponseUe(
        int idUE,
        List<Map<String,Object>> scores,
        float average,
        float nbrEtc,
        String ueName
) {
}
