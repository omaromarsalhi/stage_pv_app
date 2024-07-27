package com.stage.gateway.config;

import com.stage.gateway.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

@Configuration
public class GatewayConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public WebFilter jwtWebFilter() {
        return (ServerWebExchange exchange, WebFilterChain chain) -> {
            return jwtAuthenticationFilter.filter(exchange, chain);
        };
    }
}

