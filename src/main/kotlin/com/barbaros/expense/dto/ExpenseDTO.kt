package com.barbaros.expense.dto

import com.barbaros.expense.model.ExpenseLabel
import java.math.BigDecimal

data class ExpenseDTO(
    val id: Long? = null,
    val description: String,
    val amount: BigDecimal,
    val label: ExpenseLabel? = null
)
