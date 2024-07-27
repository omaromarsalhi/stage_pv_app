package com.stage.PV.generatepv;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/generate-pv")
@RequiredArgsConstructor
public class GeneratePvController {


    private final GeneratePvService generatePvService;


    @PostMapping("/get-user")
    public ResponseEntity<?> authenticate(
            @RequestBody GeneratePvRequest request
    ){
        return ResponseEntity.ok(generatePvService.authenticate(request));
    }

}
