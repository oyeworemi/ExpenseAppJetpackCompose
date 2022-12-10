package com.remlexworld.expenseapp.data.mapper

import com.remlexworld.expenseapp.data.remote.dto.ExpenseDto
import com.remlexworld.expenseapp.domain.model.Expense


fun ExpenseDto.toExpense(): Expense {
    return Expense(
        amount = amount,
        customerName = customerName,
        date = date,
        tripBudgetCategory = tripBudgetCategory,
        currencyCode = currencyCode,
        description = description,
        expenseVenueTitle = expenseVenueTitle,

    )
}


