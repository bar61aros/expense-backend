package com.barbaros.expense.controller;

import com.barbaros.expense.dto.AuthDTO;
import com.barbaros.expense.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody AuthDTO authDTO) {
        return authService.register(authDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthDTO authDTO) {
        return authService.login(authDTO);
    }
}
