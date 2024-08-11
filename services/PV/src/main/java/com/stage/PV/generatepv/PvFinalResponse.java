package com.stage.PV.generatepv;

import lombok.Builder;

import java.util.List;

@Builder
public record PvFinalResponse(
        List<PvResponse> pvResponseList,
        String result,
        float finalScore
) {
}
