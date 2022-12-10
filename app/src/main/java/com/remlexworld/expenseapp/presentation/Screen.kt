package com.remlexworld.expenseapp.presentation

sealed class Screen(val route: String) {
    object ExpensesListScreen : Screen("expenses_list_screen")
    object ExpenseDetailsScreen : Screen("expense_details_screen")
}
