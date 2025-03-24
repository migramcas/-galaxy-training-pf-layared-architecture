package com.migramcas.layaed.architecture.finsalud.controller.middleware;

import com.migramcas.layaed.architecture.finsalud.entity.core.User;
import com.migramcas.layaed.architecture.finsalud.entity.core.UserId;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.filters.RequestFilter;
import org.apache.juli.logging.Log;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

public class SessionMiddleware implements HandlerInterceptor {

    public static final String SESSION_USER_PARAM  = "SESSION_USER";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        User user = User.builder()
                .id(UserId.of(1))
                .name("Miguel")
                .firstLastName("Pérez")
                .secondLastName("Juárez")
                .build();

        request.setAttribute(SESSION_USER_PARAM, user);
        return true;
    }

}
