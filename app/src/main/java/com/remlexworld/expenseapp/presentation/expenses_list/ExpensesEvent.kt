package com.remlexworld.expenseapp.presentation.expenses_list

sealed class ExpensesEvent {
    object Retry: ExpensesEvent()
    object FilterExpenses: ExpensesEvent()

}
