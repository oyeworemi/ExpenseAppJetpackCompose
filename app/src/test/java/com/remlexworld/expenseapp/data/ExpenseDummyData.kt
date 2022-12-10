package com.remlexworld.expenseapp.data

import com.remlexworld.expenseapp.data.remote.dto.ExpenseDto
import com.remlexworld.expenseapp.domain.model.Expense


internal fun generateTestExpenseFromRemote() = ExpenseDto(
    amount = 20.05,
    customerName = "test customerName",
    description = "test description",
    date = "Feb 12 2022, 11:04:48 AM EST",
    type = "test type",
    tripBudgetCategory = "test tripBudgetCategory",
    currencyCode = "usd",
    expenseVenueTitle = "test expenseVenueTitle"
)


internal fun generateTestExpenseFromDomain() = Expense(
    amount = 20.05,
    customerName = "test customerName",
    description = "test description",
    date = "Feb 12 2022, 11:04:48 AM EST",
    type = "test type",
    tripBudgetCategory = "test tripBudgetCategory",
    currencyCode = "usd",
    expenseVenueTitle = "test expenseVenueTitle"
)

