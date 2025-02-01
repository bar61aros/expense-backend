package com.barbaros.expense.controller

import com.barbaros.expense.dto.ExpenseDTO
import com.barbaros.expense.exception.ResourceNotFoundException
import com.barbaros.expense.service.ExpenseService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/expenses")
class ExpenseController(private val expenseService: ExpenseService) {

    @PostMapping
    fun createExpense(@RequestBody expenseDTO: ExpenseDTO): ExpenseDTO {
        return expenseService.createExpense(expenseDTO)
    }

    @GetMapping
    fun getAllExpenses(): List<ExpenseDTO> {
        return expenseService.getAllExpenses()
    }

    @GetMapping("/{id}")
    fun getExpenseById(@PathVariable id: Long): ExpenseDTO {
        return expenseService.getExpenseById(id)
            ?: throw ResourceNotFoundException("Expense with ID $id not found")
    }
}
