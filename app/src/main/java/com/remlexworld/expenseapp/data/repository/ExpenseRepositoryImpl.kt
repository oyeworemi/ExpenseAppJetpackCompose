package com.remlexworld.expenseapp.data.repository

import com.remlexworld.expenseapp.data.remote.ExpenseApi
import com.remlexworld.expenseapp.data.remote.dto.ExpenseDto
import com.remlexworld.expenseapp.domain.repository.ExpenseRepository
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor(
    private val expenseApi: ExpenseApi
) : ExpenseRepository {


    override suspend fun getExpenses(): List<ExpenseDto> {
        return expenseApi.getExpenses()

    }


}