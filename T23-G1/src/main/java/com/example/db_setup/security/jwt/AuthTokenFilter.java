package com.example.db_setup.security.jwt;

import com.example.db_setup.model.RefreshToken;
import com.example.db_setup.model.repositories.RefreshTokenRepository;
import com.example.db_setup.security.AuthenticationPropertiesConfig;
import com.example.db_setup.security.services.UserDetailsServiceImpl;
import com.example.db_setup.services.RefreshTokenService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AuthTokenFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    private final UserDetailsServiceImpl userDetailsService;
    private final RefreshTokenService refreshTokenService;
    private final AuthenticationPropertiesConfig authProperties;

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = jwtProvider.getCookieFromRequest(request, authProperties.getJwtCookieName());
            if (jwt != null && jwtProvider.validateJwtToken(jwt)) {
                String email = jwtProvider.getUserEmailFromJwtToken(jwt);
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails,
                                null,
                                userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (ExpiredJwtException e) {
            if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                logger.error("JWT token is expired: {}", e.getMessage());
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"error\": \"TOKEN_EXPIRED\"}");
                return;
            } else {
                String token = request.getHeader(authProperties.getJwtRefreshCookieName());
                RefreshToken refreshToken = refreshTokenService.verifyToken(token);

                if (refreshToken == null) {
                    logger.error("JWT token is expired and refresh token isn't valid: returning unauthorized");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"error\": \"TOKEN_AND_REFRESH_EXPIRED\"}");
                    return;
                }

                ResponseCookie jwtCookie = jwtProvider.generateJwtCookie(refreshToken.getUser().getEmail(), refreshToken.getUser().getID());
                ResponseCookie newRefreshCookie = refreshTokenService.generateRefreshToken(refreshToken.getUser());

                response.addHeader(HttpHeaders.SET_COOKIE, jwtCookie.toString());
                response.addHeader(HttpHeaders.SET_COOKIE, newRefreshCookie.toString());
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e.getMessage());
        }

        filterChain.doFilter(request, response);
    }


}