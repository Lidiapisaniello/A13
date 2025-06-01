package com.example.db_setup.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.authentication")
@Getter
@Setter
public class AuthenticationPropertiesConfig {
    private String jwtCookieName;
    private String jwtRefreshCookieName;
    private Long jwtCookieExpirationMs;
    private Long jwtRefreshCookieExpirationMs;
}
