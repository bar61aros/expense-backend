package com.barbaros.expense.service

import com.barbaros.expense.dto.LoginDTO
import com.barbaros.expense.dto.RegisterDTO
import com.barbaros.expense.model.User
import com.barbaros.expense.repository.UserRepository
import com.barbaros.expense.security.JwtUtil
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val jwtUtil: JwtUtil
) {
    private val passwordEncoder = BCryptPasswordEncoder()

    fun register(request: RegisterDTO): String {
        if (userRepository.findByEmail(request.email).isPresent) {
            throw IllegalArgumentException("Email already in use")
        }

        val user = User(
            email =  request.email,
            password = passwordEncoder.encode(request.password)
        )

        userRepository.save(user)

        return "User registered successfully!"
    }

    fun login(request: LoginDTO): String {
        val user = userRepository.findByEmail(request.email)
            .orElseThrow { IllegalArgumentException("User not found") }

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw IllegalArgumentException("Invalid credentials")
        }

        return jwtUtil.generateToken(user.email)
    }
}
