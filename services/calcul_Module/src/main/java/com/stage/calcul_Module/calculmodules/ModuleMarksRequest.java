package com.stage.calcul_Module.calculmodules;

import jakarta.validation.constraints.NotNull;

public record ModuleMarksRequest(
        @NotNull
        int idmodule
) {
}
