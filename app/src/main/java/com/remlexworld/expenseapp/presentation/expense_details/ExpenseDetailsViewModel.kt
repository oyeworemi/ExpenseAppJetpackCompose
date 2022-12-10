package com.remlexworld.expenseapp.presentation.expense_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remlexworld.expenseapp.common.Resource
import com.remlexworld.expenseapp.domain.use_cases.get_expenses.GetExpensesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ExpenseDetailsViewModel @Inject constructor(
    ) : ViewModel() {
    private val _state = mutableStateOf(ExpenseDetailsState())
    val state: State<ExpenseDetailsState> = _state

    init {


    }

    fun onEvent(event: ExpenseDetailsEvent) {
        when(event) {
            is ExpenseDetailsEvent.Retry -> {

            }

        }
    }

}
