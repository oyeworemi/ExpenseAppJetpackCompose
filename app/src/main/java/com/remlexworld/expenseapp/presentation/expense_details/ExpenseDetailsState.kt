package com.remlexworld.expenseapp.presentation.expense_details

import com.remlexworld.expenseapp.domain.model.Expense

data class ExpenseDetailsState(
    val isLoading: Boolean = false,
    val expenses: List<Expense>? = emptyList(),
    val error: String = "",
    var totalExpenses: String = ""
)
