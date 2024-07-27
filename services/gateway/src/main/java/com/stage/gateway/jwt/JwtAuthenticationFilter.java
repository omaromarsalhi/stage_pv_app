package com.stage.gateway.jwt;


import com.stage.gateway.exeption.TokenMissingException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class JwtAuthenticationFilter implements WebFilter {

    @Autowired
    private JwtService jwtService;

    private final AntPathMatcher pathMatcher = new AntPathMatcher();
    private final List<String> excludedPaths = List.of("/api/auth/**");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        try {
            String path = exchange.getRequest().getURI().getPath();
            // Skip JWT validation for excluded paths
            if (isExcluded(path)) {
                return chain.filter(exchange);
            }

            String token = extractToken(exchange.getRequest().getHeaders().getFirst("Authorization"));

            if (token == null || !jwtService.isTokenValid(token)) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            return chain.filter(exchange);
        } catch (TokenMissingException | ExpiredJwtException e) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
            String errorMessage = "{\"token\": \"Unauthorized: Invalid or missing token Donkey\"}";
            DataBufferFactory bufferFactory = exchange.getResponse().bufferFactory();
            DataBuffer buffer = bufferFactory.wrap(errorMessage.getBytes(StandardCharsets.UTF_8));
            return exchange.getResponse().writeWith(Flux.just(buffer));
        }

    }

    private boolean isExcluded(String path) {
        return excludedPaths.stream().anyMatch(pattern -> pathMatcher.match(pattern, path));
    }

    private String extractToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        } else
            throw new TokenMissingException("missing token");
    }
}


//
//import com.stage.gateway.exeption.TokenMissingException;
//import io.jsonwebtoken.ExpiredJwtException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//
//@Component
//public class JwtAuthentificationFilter extends OncePerRequestFilter {
//
//    private JwtService jwtService;
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain
//    ) throws ServletException, IOException {
//        try {
//            final String header = request.getHeader("Authorization");
//
//            if (header == null || !header.startsWith("Bearer")) {
//                throw new TokenMissingException("JWT does not exist b1");
//            }
//
//            String token = header.substring(7);
//
//            if (!jwtService.isTokenValid(token)) {
//                throw new TokenMissingException("JWT does not exist b2");
//            }
//        }catch (TokenMissingException  e) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.setContentType("application/json");
////            response.getWriter().write("{\"token\": \"JWT does not exist\"}");
//            response.getWriter().write("{\"token\": \""+e.getMessage()+"\"}");
//        }
//        catch (ExpiredJwtException e) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.setContentType("application/json");
//            response.getWriter().write("{\"token\": \"JWT Token has expired banana\"}");
//        }
//
//
//    }
//}
