package com.migramcas.layaed.architecture.finsalud.controller.middleware;

import com.migramcas.layaed.architecture.finsalud.entity.core.User;
import com.migramcas.layaed.architecture.finsalud.entity.core.UserId;
import com.migramcas.layaed.architecture.finsalud.service.core.auth.TokenManager;
import com.migramcas.layaed.architecture.finsalud.service.core.auth.TokenManagerJWTImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class SessionMiddleware implements HandlerInterceptor {

    TokenManager tokenManager = new TokenManagerJWTImpl();

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String SESSION_USER_PARAM = "SESSION_USER";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (request.getRequestURI().startsWith("/auth/")) {
            return true;
        }

        String token = request.getHeader(AUTHORIZATION_HEADER).replaceAll("Bearer ", "");
        boolean hasAccess = tokenManager.validate(token);

        if (hasAccess) {
            User user = User.builder()
                    .id(UserId.of(1))
                    .name("Miguel")
                    .firstLastName("Pérez")
                    .secondLastName("Juárez")
                    .build();
            request.setAttribute(SESSION_USER_PARAM, user);
        }

        return hasAccess;
    }
}