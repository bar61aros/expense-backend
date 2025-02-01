package com.barbaros.expense.service

import com.barbaros.expense.dto.ExpenseDTO
import com.barbaros.expense.model.Expense
import com.barbaros.expense.repository.ExpenseRepository
import org.springframework.stereotype.Service

@Service
class ExpenseService(private val expenseRepository: ExpenseRepository) {

    fun createExpense(expenseDTO: ExpenseDTO): ExpenseDTO {
        val expense = Expense(
            description = expenseDTO.description,
            amount = expenseDTO.amount
        )
        val savedExpense = expenseRepository.save(expense)
        return ExpenseDTO(savedExpense.id, savedExpense.description, savedExpense.amount)
    }

    fun getAllExpenses(): List<ExpenseDTO> {
        return expenseRepository.findAll().map { expense ->
            ExpenseDTO(expense.id, expense.description, expense.amount)
        }
    }

    fun getExpenseById(id: Long): ExpenseDTO? {
        val expense = expenseRepository.findById(id).orElse(null) ?: return null
        return ExpenseDTO(expense.id, expense.description, expense.amount)
    }
}
