package com.stage.PV.user;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setToken(String token) {
        contextHolder.set(token);
    }

    public static String getToken() {
        return contextHolder.get();
    }

    public static void clear() {
        contextHolder.remove();
    }
}

