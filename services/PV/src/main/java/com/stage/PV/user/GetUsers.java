package com.stage.PV.user;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "authentification",
        url = "http://localhost:8888/api/users"
)
public interface GetUsers {

    @PostMapping("/students/{idGrade}")
    Optional<List<UserResponse>> getStudents(@PathVariable("idGrade") int idGrade);
}
