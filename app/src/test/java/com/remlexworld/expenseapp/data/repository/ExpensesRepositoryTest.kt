package com.remlexworld.expenseapp.data.repository

import com.remlexworld.expenseapp.data.remote.ExpenseApi
import com.remlexworld.expenseapp.domain.repository.ExpenseRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.BeforeEach

class ExpensesRepositoryTest {

    @RelaxedMockK
    private lateinit var expenseApi: ExpenseApi

    private lateinit var objectUnderTest: ExpenseRepository

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        setUpExpenseRepository()
    }

    @Test
    fun `should retrieved expenses from remote`() = runTest {
        // Given

        // When
        objectUnderTest.getExpenses()

        // Then
        coVerify { expenseApi.getExpenses() }
    }

    private fun setUpExpenseRepository() {
        objectUnderTest = ExpenseRepositoryImpl(
            expenseApi
        )
    }
}
