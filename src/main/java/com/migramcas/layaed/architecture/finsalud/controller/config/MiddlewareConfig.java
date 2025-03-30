package com.migramcas.layaed.architecture.finsalud.controller.config;

import com.migramcas.layaed.architecture.finsalud.controller.middleware.SessionMiddleware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MiddlewareConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionMiddleware())
                .addPathPatterns("/**")
                .excludePathPatterns("/auth/**");
    }

}
