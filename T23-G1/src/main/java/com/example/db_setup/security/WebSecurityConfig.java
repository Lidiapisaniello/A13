package com.example.db_setup.security;

import com.example.db_setup.security.jwt.AuthEntryPointJwt;
import com.example.db_setup.security.jwt.AuthTokenFilter;
import com.example.db_setup.security.service.PlayerDetailsServiceImpl;
import com.example.db_setup.security.service.AdminDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final PlayerDetailsServiceImpl playerDetailsService;
    private final AdminDetailsServiceImpl adminDetailsService;
    private final AuthEntryPointJwt unauthorizedHandler;
    private final AuthTokenFilter authTokenFilter;

    @Bean
    public DaoAuthenticationProvider userAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(playerDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public DaoAuthenticationProvider adminAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(adminDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    @Primary
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(
                List.of(userAuthenticationProvider(), adminAuthenticationProvider())
        );
    }

    @Bean(name = "playerAuthManager")
    public AuthenticationManager playerAuthManager() {
        return authentication -> userAuthenticationProvider().authenticate(authentication);
    }

    @Bean(name = "adminAuthManager")
    public AuthenticationManager adminAuthManager() {
        return authentication -> adminAuthenticationProvider().authenticate(authentication);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(userAuthenticationProvider())
                .authenticationProvider(adminAuthenticationProvider())
                .authorizeHttpRequests(auth -> auth
                    // Endpoints pubblici
                    .requestMatchers(
                            new AntPathRequestMatcher("/home"),
                            new AntPathRequestMatcher("/changeLanguage"),
                            new AntPathRequestMatcher("/login"),
                            new AntPathRequestMatcher("/register"),
                            new AntPathRequestMatcher("/register/success"),    
                            new AntPathRequestMatcher("/change_password"),
                            new AntPathRequestMatcher("/reset_password"),    
                            new AntPathRequestMatcher("/admin/**"), // admin views
                            new AntPathRequestMatcher("/auth/**"),  // auth api
                            new AntPathRequestMatcher("/t23/**")  // file statici
                    ).permitAll()
                    // Qualsiasi altra richiesta richiede autenticazione
                    .anyRequest().authenticated()
                );

        http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }



}