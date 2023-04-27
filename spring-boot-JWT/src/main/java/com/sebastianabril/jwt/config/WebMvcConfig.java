package com.sebastianabril.jwt.config;

import com.sebastianabril.jwt.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String [] publicPaths = new String[]{"/home", "/login"};
        registry.addInterceptor(jwtInterceptor)
                .excludePathPatterns(publicPaths);
    }
}
