package com.barbaros.expense.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil {

    @Value("\${jwt.secret}")
    private lateinit var secretKey: String

    @Value("\${jwt.expirationMs}")
    private var expirationMs: Long = 3600000 // 1 hour default

    // Generate JWT Token
    fun generateToken(email: String): String {
        return JWT.create()
            .withSubject(email)
            .withIssuedAt(Date())
            .withExpiresAt(Date(System.currentTimeMillis() + expirationMs))
            .sign(Algorithm.HMAC256(secretKey))
    }

    // Extract Email from Token
    fun extractUsername(token: String): String {
        return JWT.require(Algorithm.HMAC256(secretKey))
            .build()
            .verify(token)
            .subject
    }

    // Validate Token
    fun isTokenValid(token: String, userEmail: String): Boolean {
        return try {
            extractUsername(token) == userEmail && !isTokenExpired(token)
        } catch (e: Exception) {
            false
        }
    }

    // Check if Token is Expired
    private fun isTokenExpired(token: String): Boolean {
        return JWT.require(Algorithm.HMAC256(secretKey))
            .build()
            .verify(token)
            .expiresAt
            .before(Date())
    }
}
