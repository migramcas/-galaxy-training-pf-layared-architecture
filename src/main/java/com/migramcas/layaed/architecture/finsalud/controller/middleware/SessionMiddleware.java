package com.migramcas.layaed.architecture.finsalud.controller.middleware;

import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.UserId;
import com.migramcas.layaed.architecture.finsalud.repository.sqlserver.UserRepository;
import com.migramcas.layaed.architecture.finsalud.service.core.auth.TokenManager;
import com.migramcas.layaed.architecture.finsalud.repository.jwt.TokenManagerJWTImpl;
import com.migramcas.layaed.architecture.finsalud.service.exception.InvalidLoginException;
import com.migramcas.layaed.architecture.finsalud.service.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import static com.migramcas.layaed.architecture.finsalud.repository.jwt.TokenManagerJWTImpl.CLAIM_ID;

@Component
public class SessionMiddleware implements HandlerInterceptor {

    private static final String MSG_INVALID_TOKEN = "El token suministrado es inválido";

    TokenManager tokenManager = new TokenManagerJWTImpl();
    UserRepository userRepository;

    @Autowired
    public SessionMiddleware(TokenManager tokenManager, UserRepository userRepository) {
        this.tokenManager = tokenManager;
        this.userRepository = userRepository;
    }

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String SESSION_USER_PARAM = "SESSION_USER";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws UserNotFoundException, InvalidLoginException {
        String requestURI = request.getRequestURI();
        if (requestURI.startsWith("/auth/")||requestURI.contains("swagger")) {
            return true;
        }

        String token = request.getHeader(AUTHORIZATION_HEADER).replaceAll("Bearer ", "");
        boolean hasAccess = tokenManager.validate(token);

        if (!hasAccess) {
            throw new InvalidLoginException(MSG_INVALID_TOKEN);
        }

        if (request.getAttribute(SESSION_USER_PARAM) == null) {
            UserId userId = UserId.of(Integer.valueOf(tokenManager.getPayload(token).get(CLAIM_ID)));
            User user = userRepository
                    .getUserById(userId)
                    .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));
            request.setAttribute(SESSION_USER_PARAM, user);
        }

        return true;
    }
}