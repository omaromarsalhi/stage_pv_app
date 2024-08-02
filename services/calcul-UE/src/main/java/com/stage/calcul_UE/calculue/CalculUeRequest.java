package com.stage.calcul_UE.calculue;

import jakarta.validation.constraints.NotNull;

public record CalculUeRequest(
        @NotNull
        int idPE,
        @NotNull
        int idStudent
) {
}
