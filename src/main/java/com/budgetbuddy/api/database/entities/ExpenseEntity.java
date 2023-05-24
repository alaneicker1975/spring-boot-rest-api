package com.budgetbuddy.api.database.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expense")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpenseEntity {
    @Column(name = "expense_id", updatable = false, insertable = false)
    @GeneratedValue
    @Id
    private Long id;

    @Column(name = "expense_name", length = 75, nullable = false)
    @NonNull
    private String name;
}
