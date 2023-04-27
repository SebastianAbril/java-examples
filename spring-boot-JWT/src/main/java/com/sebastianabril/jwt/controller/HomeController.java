package com.sebastianabril.jwt.controller;

import com.sebastianabril.jwt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private AuthService authService;

    @GetMapping("/home")
    public String home() {
        return "Bienvenido a mi aplicación!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Esta es una página para administradores";
    }

    @GetMapping("/user")
    public String user() {
        return "Esta es una página para usuarios";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO request) {
        String token = authService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(token);
    }
}
