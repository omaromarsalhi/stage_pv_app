package com.stage.PV.calculatescores;

import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record UeResponse(
        int idUE,
        List<Map<String,Object>> scores,
        float average,
        float nbrEtc,
        String ueName
) {
}