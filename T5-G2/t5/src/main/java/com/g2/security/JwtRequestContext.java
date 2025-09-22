package com.g2.security;

public class JwtRequestContext {

    private JwtRequestContext() {
        throw new IllegalStateException("Classe utility che memorizza il JWT ricevuto dall'utente");
    }

    private static final ThreadLocal<String> jwtTokenHolder = new ThreadLocal<>();

    public static void setJwtToken(String token) {
        jwtTokenHolder.set(token);
    }

    public static String getJwtToken() {
        return jwtTokenHolder.get();
    }

    public static void clear() {
        jwtTokenHolder.remove();
    }
}
