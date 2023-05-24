package com.budgetbuddy.api.controllers;

import com.budgetbuddy.api.database.entities.ExpenseEntity;
import com.budgetbuddy.api.database.repositories.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/expense")
@RequiredArgsConstructor
@Validated
public class ExpenseController {

    private final ExpenseRepository expenseRepository;

    @GetMapping
    public List<ExpenseEntity> getAllExpense() {
        return expenseRepository.findAll();
    }

    @PostMapping
    public ExpenseEntity createExpense(@Valid @RequestBody ExpenseEntity expense) {
        return expenseRepository.save(expense);
    }

    @PutMapping("/{id}")
    public ExpenseEntity updateExpense(
            @Valid @PathVariable(value = "id") Long expenseId,
            @RequestBody ExpenseEntity expense) throws Exception {

        ExpenseEntity foundExpense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new Exception("customer not found"));

        foundExpense.setName(expense.getName());

        return expenseRepository.save(foundExpense);
    }
}
