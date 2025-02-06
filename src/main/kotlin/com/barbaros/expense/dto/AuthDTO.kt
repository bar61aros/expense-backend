package com.barbaros.expense.dto

data class RegisterDTO(
    val email: String,
    val password: String
)

data class LoginDTO(
    val email: String,
    val password: String
)
