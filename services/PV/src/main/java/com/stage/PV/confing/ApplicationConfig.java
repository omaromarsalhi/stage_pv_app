package com.stage.PV.confing;

import com.stage.PV.authentication.FeignClientInterceptor;
import com.stage.PV.authentication.GetUsers;
import com.stage.PV.authentication.UserResponse;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

public class ApplicationConfig {

    @Bean
    public FeignClientInterceptor feignClientInterceptor() {
        return new FeignClientInterceptor();
    }


}
