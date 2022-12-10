package com.remlexworld.expenseapp.data.domain.use_case

import app.cash.turbine.test
import com.remlexworld.expenseapp.data.generateTestExpenseFromDomain
import com.remlexworld.expenseapp.data.mapper.toExpense
import com.remlexworld.expenseapp.domain.repository.ExpenseRepository
import com.remlexworld.expenseapp.domain.use_cases.get_expenses.SumTotalExpensesUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class SumTotalExpensesUseCaseTest {

    @RelaxedMockK
    private lateinit var expenseRepository: ExpenseRepository

    private lateinit var objectUnderTest: SumTotalExpensesUseCase

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        setUpSumTotalExpensesUseCase()
    }


    @Test
    fun `should wrap result with success if repository doesn't throw`() = runTest {
        // Given
        val testNewsFeedFromDomain = listOf(generateTestExpenseFromDomain())
        coEvery { expenseRepository.getExpenses().map { it.toExpense() } } returns (testNewsFeedFromDomain)

        // When-Then
        objectUnderTest.invoke(testNewsFeedFromDomain).test {
            val result = awaitItem()

        /*   assertEquals(
                expected = Result.success(testNewsFeedFromDomain),
                actual = result
            )

            */

            awaitComplete()
        }
    }


    @Test
    fun `should wrap result with failure if repository throws other Exception`() = runTest {
        // Given
        val testException = Exception("Test message")
        val testExpenseFromDomain = listOf(generateTestExpenseFromDomain())
        coEvery { expenseRepository.getExpenses() } throws testException

        // When-Then
        assertThrows<Exception> {
            objectUnderTest.invoke(testExpenseFromDomain).test {
                val result = awaitItem()

            /*    assertEquals(
                    expected = Result.failure(testException),
                    actual = result
                )
                */

            }

        }
    }

    private fun setUpSumTotalExpensesUseCase() {
        objectUnderTest = SumTotalExpensesUseCase ()
    }
}
