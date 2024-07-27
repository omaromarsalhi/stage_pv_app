package com.stage.PV.authentication;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@FeignClient(
        name = "customer-service",
        url = "${application.config.authentication-url}"
)
public interface AuthenticateAndGetUserClient {

    @GetMapping
    Optional<AuthenticationResponse> authenticateAndGetUser();
}
