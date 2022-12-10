package com.remlexworld.expenseapp.domain.use_cases.get_expenses

import com.remlexworld.expenseapp.common.Resource
import com.remlexworld.expenseapp.data.mapper.toExpense
import com.remlexworld.expenseapp.data.remote.dto.ExpenseDto
import com.remlexworld.expenseapp.domain.model.Expense
import com.remlexworld.expenseapp.domain.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SumTotalExpensesUseCase @Inject constructor() {

    operator fun invoke(expenses: List<Expense>): Flow<Resource<String>> = flow {
        try {

            var totalAmount = sumTotalAmount(expenses)

            emit(Resource.Success(totalAmount.toString()))

        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }

    private fun sumTotalAmount (expenses: List<Expense>) : Double {
        var totalAmount = 0.0
        for(expense in expenses){
                totalAmount += expense.amount!!
            }

        return totalAmount
    }

}