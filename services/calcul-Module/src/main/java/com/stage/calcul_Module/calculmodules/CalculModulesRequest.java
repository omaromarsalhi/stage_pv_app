package com.stage.calcul_Module.calculmodules;

import jakarta.validation.constraints.NotNull;

public record CalculModulesRequest(
        @NotNull
        int idmodule,
        @NotNull
        int idstudent
) {
}
