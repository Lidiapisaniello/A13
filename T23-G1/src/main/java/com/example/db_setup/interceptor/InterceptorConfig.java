package com.example.db_setup.interceptor;

import com.example.db_setup.security.jwt.JwtProvider;
import com.example.db_setup.service.AuthService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private final JwtProvider jwtProvider;
    private final AuthService authService;

    public InterceptorConfig(JwtProvider jwtProvider, AuthService authService) {
        this.jwtProvider = jwtProvider;
        this.authService = authService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticatedUserInterceptor(jwtProvider, authService));
    }
}
