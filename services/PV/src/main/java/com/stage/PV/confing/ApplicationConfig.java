package com.stage.PV.confing;

import com.stage.PV.authentication.AuthenticateAndGetUserClient;
import com.stage.PV.authentication.FeignClientInterceptor;
import com.stage.PV.authentication.JwtTokenContextHolder;
import org.springframework.context.annotation.Bean;

public class ApplicationConfig {

    @Bean
    public FeignClientInterceptor feignClientInterceptor() {
        return new FeignClientInterceptor();
    }

}
