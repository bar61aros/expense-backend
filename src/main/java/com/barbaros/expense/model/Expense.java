package com.barbaros.expense.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDateTime createdAt = LocalDateTime.now();
    private ExpenseLabel label;

    public Expense() {
    }

    public Expense(String description, BigDecimal amount) {
        this.description = description;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
    }
}
