package com.example.db_setup.interceptors;

import com.example.db_setup.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.apache.hc.core5.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class AuthenticatedUserInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticatedUserInterceptor.class);

    private final UrlPathHelper urlPathHelper = new UrlPathHelper();
    private final JwtProvider jwtProvider;

    private final List<String> includeUrls = new ArrayList<String>(){{
        add("/login");
    }};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Cookie[] requestCookies = request.getCookies();
        if (requestCookies == null)
            return true;

        Cookie authCookie = Arrays.stream(requestCookies)
                .filter(cookie -> cookie.getName().equals("jwt"))
                .findFirst()
                .orElse(null);

        if (includeUrls.contains(urlPathHelper.getLookupPathForRequest(request)) && isAuthenticated(authCookie)) {
            String encodedRedirectURL = response.encodeRedirectURL(
                    request.getContextPath() + "/main");
            response.setStatus(HttpStatus.SC_TEMPORARY_REDIRECT);
            response.setHeader("Location", encodedRedirectURL);

            return false;
        } else {
            return true;
        }
    }

    private boolean isAuthenticated(Cookie authCookie) {
        return authCookie != null &&  jwtProvider.validateJwtToken(authCookie.getValue());
        /*
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Authentication : {}", authentication);
        return authentication != null && authentication.isAuthenticated();

         */
    }
}
