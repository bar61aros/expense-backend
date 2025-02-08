package com.barbaros.expense.service;

import com.barbaros.expense.dto.ExpenseDTO;
import com.barbaros.expense.model.Expense;
import com.barbaros.expense.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense(expenseDTO.getDescription(), expenseDTO.getAmount());
        Expense savedExpense = expenseRepository.save(expense);
        return new ExpenseDTO(savedExpense.getId(), savedExpense.getDescription(), savedExpense.getAmount(), savedExpense.getLabel());
    }

    public List<ExpenseDTO> getAllExpenses() {
        return expenseRepository.findAll()
                .stream()
                .map(expense -> new ExpenseDTO(expense.getId(), expense.getDescription(), expense.getAmount(), expense.getLabel()))
                .collect(Collectors.toList());
    }

    public ExpenseDTO getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .map(expense -> new ExpenseDTO(expense.getId(), expense.getDescription(), expense.getAmount(), expense.getLabel()))
                .orElse(null);
    }
}
