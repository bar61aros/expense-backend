package com.barbaros.expense.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity
@Table(name = "expenses")
data class Expense(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val description: String = "",
    val amount: BigDecimal = BigDecimal.ZERO,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
