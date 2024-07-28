package com.stage.PV.generatepv;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/generate-pv")
@RequiredArgsConstructor
public class GeneratePvController {


    private final GeneratePvService generatePvService;


    @PostMapping("/getStudents")
    public ResponseEntity<?> retrieveStudents(
            @RequestBody StudentsRequest request,
            @RequestHeader("Authorization") String headerValue
    ){
        return ResponseEntity.ok(generatePvService.retrieveStudents(request,headerValue));
    }

}
