package com.example.db_setup.security.jwt;

import testrobotchallenge.commons.models.user.Role;
import com.example.db_setup.security.AuthenticationPropertiesConfig;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private final AuthenticationPropertiesConfig authProperties;

    private final String keySecret = System.getenv("JWT_KEY_SECRET");

    public ResponseCookie generateJwtCookie(String email, Long userId, Role role) {
        String jwt = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + authProperties.getJwtCookieExpirationMs()))
                .claim("userId", userId)
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS256, keySecret)
                .compact();

        return ResponseCookie.from(authProperties.getJwtCookieName(), jwt)
                .path("/")
                .maxAge(authProperties.getJwtCookieExpirationMs() / 1000 + 7200)
                .build();
    }

    public ResponseCookie getCleanJwtCookie() {
        return ResponseCookie.from(authProperties.getJwtCookieName(), "").path("/").maxAge(0).build();
    }

    public String getUserEmailFromJwtToken(String authToken) {
        Claims claims = Jwts.parser()
                .setSigningKey(keySecret)
                .parseClaimsJws(authToken)
                .getBody();

        return claims.getSubject();
    }

    public Role getUserRoleFromJwtToken(String authToken) {
        Claims claims = Jwts.parser()
                .setSigningKey(keySecret)
                .parseClaimsJws(authToken)
                .getBody();

        return Role.valueOf(claims.get("role", String.class));
    }

    public JwtValidationResult validateJwtToken(String authToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(keySecret)
                    .parseClaimsJws(authToken)
                    .getBody();

            if (Instant.now().isBefore(claims.getExpiration().toInstant())) {
                logger.info("Jwt is valid");
                return new JwtValidationResult(true, null, null);
            } else {
                logger.info("Jwt is expired");
                return new JwtValidationResult(false, "EXPIRED", "JWT token is expired");
            }

        } catch (MalformedJwtException e) {
            logger.info("Jwt is malformed: {}", e.getMessage());
            return new JwtValidationResult(false, "MALFORMED", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.info("Jwt is unsupported: {}", e.getMessage());
            return new JwtValidationResult(false, "UNSUPPORTED", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.info("Jwt is empty: {}", e.getMessage());
            return new JwtValidationResult(false, "EMPTY", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.info("Jwt is expired: {}", e.getMessage());
            return new JwtValidationResult(false, "EXPIRED", e.getMessage());
        } catch (Exception e) {
            logger.info("Jwt is invalid: {}", e.getMessage());
            return new JwtValidationResult(false, "INVALID", e.getMessage());
        }
    }
}
