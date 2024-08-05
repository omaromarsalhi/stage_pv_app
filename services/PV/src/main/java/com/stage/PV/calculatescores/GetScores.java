package com.stage.PV.calculatescores;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "calcul-UE",
        url = "http://localhost:8888/api/ue/send-to-other"
)
public interface GetScores {

    @GetMapping("/{idStudent}/{idModule}")
    Optional<UeResponse> getScores(@PathVariable("idStudent") int idStudent, @PathVariable("idModule") int idModule);
}
