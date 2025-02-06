package com.barbaros.expense.repository

import com.barbaros.expense.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String): Optional<User>
}
