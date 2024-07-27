package com.stage.gateway.config;

import com.stage.gateway.jwt.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

@Configuration
@AllArgsConstructor
public class GatewayConfig {


    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public WebFilter jwtWebFilter() {
        return jwtAuthenticationFilter;
    }
}

