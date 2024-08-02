package com.stage.calcul_UE.calculue;

import jakarta.validation.constraints.NotNull;

public record CalculUeRequest(
        @NotNull
        int idUE,
        @NotNull
        int idstudent
) {
}
