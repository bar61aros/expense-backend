package com.barbaros.expense.repository

import com.barbaros.expense.model.Expense
import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseRepository: JpaRepository<Expense, Long>
