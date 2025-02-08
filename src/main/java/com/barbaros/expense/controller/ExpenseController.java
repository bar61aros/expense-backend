package com.barbaros.expense.controller;

import com.barbaros.expense.dto.ExpenseDTO;
import com.barbaros.expense.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ExpenseDTO createExpense(@RequestBody ExpenseDTO expenseDTO) {
        return expenseService.createExpense(expenseDTO);
    }

    @GetMapping
    public List<ExpenseDTO> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public ExpenseDTO getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }
}
