package com.barbaros.expense.dto;

import com.barbaros.expense.model.ExpenseLabel;

import java.math.BigDecimal;

public class ExpenseDTO {
    private Long id = null;
    private ExpenseLabel label = null;
    private String description;
    private BigDecimal amount;

    public ExpenseDTO() {
    }

    public ExpenseDTO(Long id, String description, BigDecimal amount, ExpenseLabel label) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExpenseLabel getLabel() {
        return label;
    }

    public void setLabel(ExpenseLabel label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
