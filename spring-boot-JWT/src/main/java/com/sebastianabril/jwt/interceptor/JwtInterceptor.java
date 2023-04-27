package com.sebastianabril.jwt.interceptor;

import com.sebastianabril.jwt.service.JWTService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JWTService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            throw new RuntimeException("Token no encontrado");
        }
        token = token.substring(7);

        if (!jwtService.validate(token)) {
            throw new RuntimeException("Token inválido");
        }

        Claims claims = jwtService.getClaims(token);
        Integer roleId = (Integer) claims.get("roleId");

        if (request.getRequestURI().startsWith("/admin")) {
            if (roleId.equals(1)) {
                return true;
            } else {
                throw new RuntimeException("No tiene permisos para acceder a este recurso");
            }
        }

        return true;
    }

}
