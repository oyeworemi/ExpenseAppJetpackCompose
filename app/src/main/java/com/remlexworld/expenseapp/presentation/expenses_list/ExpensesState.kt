package com.remlexworld.expenseapp.presentation.expenses_list

import com.remlexworld.expenseapp.domain.model.Expense

data class ExpensesState(
    val isLoading: Boolean = false,
    val expenses: List<Expense>? = emptyList(),
    val filteredExpenses: List<Expense>? = emptyList(),
    val error: String = "",
    var totalExpenses: String? = ""
)
