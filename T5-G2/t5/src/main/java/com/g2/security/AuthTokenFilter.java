package com.g2.security;

import com.g2.interfaces.ServiceManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;
import testrobotchallenge.commons.models.dto.auth.JwtValidationResponseDTO;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static testrobotchallenge.commons.models.user.Role.PLAYER;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {
    private static final Logger customLogger = LoggerFactory.getLogger(AuthTokenFilter.class);
    private final ServiceManager serviceManager;
    private final RestTemplate restTemplate = new RestTemplate();

    public AuthTokenFilter(ServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        customLogger.info("[AuthTokenFilter] Authenticating request {} {}", request.getMethod(), request.getRequestURI());

        Cookie jwtCookie = WebUtils.getCookie(request, "jwt");
        Cookie refreshCookie = WebUtils.getCookie(request, "jwt-refresh");

        String jwt = jwtCookie != null ? jwtCookie.getValue() : null;
        String refreshToken = refreshCookie != null ? refreshCookie.getValue() : null;

        try {
            if (jwt == null) {
                if (refreshCookie != null) {
                    customLogger.info("JWT missing. Attempting to refresh using refresh token...");
                    tryRefreshAndContinue(refreshToken, response, chain, request);
                    return;
                } else {
                    customLogger.info("JWT and refresh token missing. Redirecting to login.");
                    redirectToLogin(response, "unauthorized");
                    return;
                }
            }

            JwtValidationResponseDTO validation = (JwtValidationResponseDTO) serviceManager.handleRequest("T23", "GetAuthenticated", jwt);
            if (!validation.isValid() || !validation.getRole().equals(PLAYER)) {
                customLogger.info("[AuthTokenFilter] Invalid token or insufficient permissions.");
                redirectToLogin(response, "unauthorized");
                return;
            }

            customLogger.info("[AuthTokenFilter] Validated token for role PLAYER");
            JwtRequestContext.setJwtToken("%s=%s".formatted(jwtCookie.getName(), jwt));
            customLogger.debug("[AuthTokenFilter] JWT saved in thread context");

            chain.doFilter(request, response);

        } finally {
            JwtRequestContext.clear();
        }
    }

    private void tryRefreshAndContinue(String refreshToken, HttpServletResponse response, FilterChain chain, HttpServletRequest request)
            throws IOException {

        String cookies = callRefreshJwtToken(refreshToken);
        if (cookies == null) {
            customLogger.warn("Refresh token failed: JWT is null");
            redirectToLogin(response, "expired");
            return;
        }

        try {
            Map<String, String> cookieAttrs = parseCookieAttributes(cookies);
            String newJwt = cookieAttrs.get("jwt");
            int maxAge = Integer.parseInt(cookieAttrs.getOrDefault("max-age", "3600"));
            String path = cookieAttrs.getOrDefault("path", "/");

            ResponseCookie newJwtCookie = ResponseCookie.from("jwt", newJwt)
                    .path(path)
                    .maxAge(maxAge)
                    .httpOnly(true)
                    .build();

            response.setHeader(HttpHeaders.SET_COOKIE, newJwtCookie.toString());
            JwtRequestContext.setJwtToken(newJwtCookie.toString());

            customLogger.info("JWT refreshed and saved in context. Proceeding with filter chain.");
            chain.doFilter(request, response);

        } catch (Exception ex) {
            customLogger.warn("Refresh token failed: {}", ex.getMessage());
            redirectToLogin(response, "expired");
        }
    }

    private void redirectToLogin(HttpServletResponse response, String reason) throws IOException {
        response.sendRedirect("/login?" + reason + "=true");
    }

    private String callRefreshJwtToken(String refreshToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.COOKIE, "jwt-refresh=" + refreshToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                "http://t23-controller:8082/auth/refreshToken",
                HttpMethod.POST,
                entity,
                Map.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            List<String> cookies = response.getHeaders().get(HttpHeaders.SET_COOKIE);

            if (cookies != null) {
                for (String cookie : cookies) {
                    if (cookie.startsWith("jwt=")) {
                        return cookie;
                    }
                }
            }
        }

        return null;
    }

    private Map<String, String> parseCookieAttributes(String setCookieHeader) {
        Map<String, String> attributes = new HashMap<>();
        String[] parts = setCookieHeader.split(";");
        for (String part : parts) {
            String[] keyValue = part.trim().split("=", 2);
            if (keyValue.length == 2) {
                attributes.put(keyValue[0].toLowerCase(), keyValue[1]);
            } else {
                attributes.put(keyValue[0].toLowerCase(), "true");
            }
        }
        return attributes;
    }


}
