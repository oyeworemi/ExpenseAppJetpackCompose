package com.remlexworld.expenseapp.domain.repository

import com.remlexworld.expenseapp.data.remote.dto.ExpenseDto

interface ExpenseRepository {
    suspend fun getExpenses(): List<ExpenseDto>
}