package com.barbaros.expense.dto

import java.math.BigDecimal

data class ExpenseDTO(
    val id: Long? = null,
    val description: String,
    val amount: BigDecimal
)
