package com.example.db_setup.security.jwt;

import testrobotchallenge.commons.models.user.Role;
import com.example.db_setup.security.AuthenticationPropertiesConfig;
import com.example.db_setup.security.service.AdminDetailsServiceImpl;
import com.example.db_setup.security.service.PlayerDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    private final PlayerDetailsServiceImpl playerDetailsService;
    private final AdminDetailsServiceImpl adminDetailsService;
    private final AuthenticationPropertiesConfig authProperties;

    private static final Logger customLogger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            Cookie cookie = WebUtils.getCookie(request, authProperties.getJwtCookieName());
            customLogger.info("jwt cookie found: {}", cookie);
            String jwt = cookie != null ? cookie.getValue() : null;

            customLogger.info("[AuthTokenFilter] Filtering request with jwt {} on request {}", jwt, request);
            logRequestInfo(request);
            if (jwt != null && jwtProvider.validateJwtToken(jwt).isValid()) {
                String email = jwtProvider.getUserEmailFromJwtToken(jwt);
                Role role = jwtProvider.getUserRoleFromJwtToken(jwt);
                UserDetails userDetails = role.equals(Role.ADMIN) ?
                        adminDetailsService.loadUserByUsername(email) :
                        playerDetailsService.loadUserByUsername(email);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails,
                                null,
                                userDetails.getAuthorities());

                customLogger.info("[AuthTokenFilter] Jwt is valid, setting authentication context");
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            customLogger.error("Cannot set user authentication: {}", e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    private void logRequestInfo(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        sb.append("[AuthTokenFilter] Request info:\n");
        sb.append("Method: ").append(request.getMethod()).append("\n");
        sb.append("Request URI: ").append(request.getRequestURI()).append("\n");
        sb.append("Query String: ").append(request.getQueryString()).append("\n");
        sb.append("Remote Addr: ").append(request.getRemoteAddr()).append("\n");
        sb.append("Headers: \n");

        var headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            sb.append("  ").append(headerName).append(": ")
                    .append(request.getHeader(headerName)).append("\n");
        }

        customLogger.info("{}", sb);
    }

}