package com.basic.auth.controller;

import com.basic.auth.dto.AuthRequest;
import com.basic.auth.dto.AuthResponse;
import com.basic.auth.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController1 {

    private final AuthService authService;

    @PostMapping("/signup")
    public String signup(
            @RequestBody AuthRequest request
    ) {
        authService.signup(request);
        return "Signup Successful";
    }

    @PostMapping("/login")
    public String login(
            @RequestBody AuthRequest authRequest,
            HttpServletRequest request
    ) {
        AuthResponse result = authService.login(authRequest);

        HttpSession session = request.getSession();
        session.setAttribute("LOGIN_DIRECTOR", result.getId());
        return "Login Successful";
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
