package com.example.db_setup.interceptors;

import com.example.db_setup.security.jwt.JwtProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration
public class AuthenticatedUserRedirectConfig implements WebMvcConfigurer {

    private final JwtProvider jwtProvider;

    public AuthenticatedUserRedirectConfig(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticatedUserInterceptor(jwtProvider));
    }
}
