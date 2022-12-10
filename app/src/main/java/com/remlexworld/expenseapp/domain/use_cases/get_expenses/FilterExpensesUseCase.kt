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

class FilterExpensesUseCase @Inject constructor() {

    operator fun invoke(expenses: List<Expense>, searchKeyword: String): Flow<Resource<List<Expense>>> = flow {
        try {
            emit(Resource.Loading())

            var filteredExpensesByCategory = expenses.filter { expense -> expense.tripBudgetCategory == searchKeyword }
            var filteredExpensesByTitle = expenses.filter { expense -> expense.expenseVenueTitle == searchKeyword }

            if (filteredExpensesByCategory.isNotEmpty()) {
                emit(Resource.Success(filteredExpensesByCategory))
            } else {
                emit(Resource.Success(filteredExpensesByTitle))
            }


        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }


}