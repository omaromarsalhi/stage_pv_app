package com.stage.PV.generatepv;


import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record PvResponse(
        String name,
        float nbr_etc,
        float moy_ue,
        List<Map<String,Object>> module
) {
}
