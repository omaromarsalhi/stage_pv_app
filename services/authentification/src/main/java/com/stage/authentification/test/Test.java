package com.stage.authentification.test;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class Test {


    @PostMapping("/test_test")
    public String test(
    ) {
        return "hi omar";
    }

}
