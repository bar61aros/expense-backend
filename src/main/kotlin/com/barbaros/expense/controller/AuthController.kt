package com.barbaros.expense.controller

import com.barbaros.expense.dto.LoginDTO
import com.barbaros.expense.dto.RegisterDTO
import com.barbaros.expense.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController (private val authService: AuthService) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterDTO) : String{
        return authService.register(request)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginDTO): String {
        return authService.login(request)
    }
}
