package com.example.db_setup.security.jwt;

import com.example.db_setup.security.AuthenticationPropertiesConfig;
import com.example.db_setup.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private final AuthenticationPropertiesConfig authProperties;

    public String getCookieFromRequest(HttpServletRequest request, String name) {
        Cookie cookie = WebUtils.getCookie(request, name);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    public ResponseCookie generateJwtCookie(String email, Integer id) {
        String jwt = generateTokenFromEmail(email, id);
        ResponseCookie cookie = ResponseCookie.from(authProperties.getJwtCookieName(), jwt)
                .path("/")
                .maxAge(24 * 60 * 60)
                .build();

        return cookie;
    }

    public ResponseCookie getCleanJwtCookie() {
        ResponseCookie cookie = ResponseCookie.from(authProperties.getJwtCookieName(), "").path("/").maxAge(0).build();
        return cookie;
    }

    public String getUserEmailFromJwtToken(String authToken) {
        Claims claims = Jwts.parser()
                .setSigningKey("mySecretKey")
                .parseClaimsJws(authToken)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("mySecretKey")
                    .parseClaimsJws(authToken)
                    .getBody();

            return Instant.now().isBefore(claims.getExpiration().toInstant());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public String generateTokenFromEmail(String email, Integer userId) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + authProperties.getJwtCookieExpirationMs()))
                .claim("userId", userId)
                .claim("role", "user")
                .signWith(SignatureAlgorithm.HS256, "mySecretKey")
                .compact();
    }
}
