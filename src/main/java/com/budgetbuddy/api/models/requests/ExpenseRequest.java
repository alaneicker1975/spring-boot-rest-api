package com.budgetbuddy.api.models.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ExpenseRequest {
  private Long expenseId;

  @NotNull(message = "Please enter expense name")
  private String name;
}
