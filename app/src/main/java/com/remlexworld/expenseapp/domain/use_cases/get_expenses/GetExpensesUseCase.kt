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

class GetExpensesUseCase @Inject constructor(private val repository: ExpenseRepository) {

    operator fun invoke(): Flow<Resource<List<Expense>>> = flow {
        try {
            emit(Resource.Loading())

            var remoteExpenses = repository.getExpenses()

            emit(Resource.Success(remoteExpenses.map { it.toExpense() }))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage
                        ?: "Couldn't reach the server. Check your internet connection"
                )
            )

        }
    }


}