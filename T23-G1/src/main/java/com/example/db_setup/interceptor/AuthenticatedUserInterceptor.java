package com.example.db_setup.interceptor;

import testrobotchallenge.commons.models.user.Role;
import com.example.db_setup.security.jwt.JwtProvider;
import com.example.db_setup.service.AuthService;
import org.apache.hc.core5.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthenticatedUserInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticatedUserInterceptor.class);

    private final UrlPathHelper urlPathHelper = new UrlPathHelper();
    private final JwtProvider jwtProvider;
    private final AuthService authService;

    private List<String> playerUrls;
    private List<String> adminUrls;

    public AuthenticatedUserInterceptor(JwtProvider jwtProvider, AuthService authService) {
        this.jwtProvider = jwtProvider;
        this.authService = authService;

        playerUrls = new ArrayList<>();
        playerUrls.add("/login");
        playerUrls.add("/register");
        playerUrls.add("/change_password");
        playerUrls.add("/reset_password");

        adminUrls = new ArrayList<>();
        adminUrls.add("/admin/login");
        adminUrls.add("/admin/register");
        adminUrls.add("/admin/change_password");
        adminUrls.add("/admin/reset_password");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Cookie[] requestCookies = request.getCookies();
        if (requestCookies == null)
            return true;

        Cookie authCookie = Arrays.stream(requestCookies)
                .filter(cookie -> cookie.getName().equals("jwt"))
                .findFirst()
                .orElse(null);

        if (!playerUrls.contains(urlPathHelper.getLookupPathForRequest(request)) && !adminUrls.contains(urlPathHelper.getLookupPathForRequest(request)))
            return true;

        String unauthorizedParam = request.getParameter("unauthorized");
        String expiredParam = request.getParameter("expired");
        if (unauthorizedParam != null) {
            logger.info("Found query param 'unauthorized' in request");
            return true;
        } else if (expiredParam != null) {
            logger.info("Found query param 'expired' in request");
            return true;
        }

        logger.info("[AuthenticatedUserInterceptor] Intercepting request {} for redirect", urlPathHelper.getLookupPathForRequest(request));

        if (isAuthenticated(authCookie)) {
            String encodedRedirectURL;
            Role userRole = extractUserRole(authCookie);

            logger.info("[AuthenticatedUserInterceptor] User is authenticated with role {}", userRole);

            if (userRole.equals(Role.PLAYER) && playerUrls.contains(urlPathHelper.getLookupPathForRequest(request))) {
                encodedRedirectURL = response.encodeRedirectURL(
                        request.getContextPath() + "/main");
                response.setStatus(HttpStatus.SC_TEMPORARY_REDIRECT);
                response.setHeader("Location", encodedRedirectURL);
                logger.info("[AuthenticatedUserInterceptor] Redirecting to /main");
                return false;
            } else if (userRole.equals(Role.ADMIN) && adminUrls.contains(urlPathHelper.getLookupPathForRequest(request))) {
                encodedRedirectURL = response.encodeRedirectURL(
                        request.getContextPath() + "/dashboard");
                response.setStatus(HttpStatus.SC_TEMPORARY_REDIRECT);
                response.setHeader("Location", encodedRedirectURL);
                logger.info("[AuthenticatedUserInterceptor] Redirecting to /dashboard");
                return false;
            }

            logger.info("[AuthenticatedUserInterceptor] Role incompatible with redirect, proceeding without redirecting");
            return true;
        } else {
            logger.info("[AuthenticatedUserInterceptor] User is not authenticated, proceeding without redirecting");
            return true;
        }
    }

    private boolean isAuthenticated(Cookie authCookie) {
        return authCookie != null &&  authService.validateToken(authCookie.getValue()).isValid();
    }

    private Role extractUserRole(Cookie authCookie) {
        return jwtProvider.getUserRoleFromJwtToken(authCookie.getValue());
    }
}
