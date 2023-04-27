package com.sebastianabril.jwt.service;

import com.sebastianabril.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JWTService jwtService;

    public String login(String email, String password) {
        User user = findUser(email, password);
        String token = jwtService.createToken(user);
        return token;
    }

    private User findUser(String email, String password) {
        if (email.equals("jhon@gmail.com") && password.equals("123456")) {
            return new User(1, "jhon@gmail.com", "123456", 2);
        }

        if (email.equals("jane@gmail.com") && password.equals("123456")) {
            return new User(1, "jane@gmail.com", "123456", 1);
        }

        throw  new RuntimeException("Invalid credentials");
    }



}
