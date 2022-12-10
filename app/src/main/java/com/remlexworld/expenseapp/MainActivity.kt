package com.remlexworld.expenseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.remlexworld.expenseapp.common.Constants
import com.remlexworld.expenseapp.domain.model.AssetParamType
import com.remlexworld.expenseapp.domain.model.Expense
import com.remlexworld.expenseapp.presentation.Screen
import com.remlexworld.expenseapp.presentation.expense_details.ExpenseDetailsScreen
import com.remlexworld.expenseapp.presentation.expenses_list.ExpensesScreen
import com.remlexworld.expenseapp.presentation.expenses_list.ExpensesViewModel
import com.remlexworld.expenseapp.ui.theme.ExpenseAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   // private val viewModel: ExpensesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ExpenseAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ExpensesListScreen.route
                    ) {


                        composable(
                            route = Screen.ExpensesListScreen.route
                        ) {
                            ExpensesScreen(navController = navController)
                        }

                        composable(
                            route = Screen.ExpenseDetailsScreen.route + "/{${Constants.PARAM_EXPENSE}}",
                            arguments = listOf(navArgument(Constants.PARAM_EXPENSE) {
                                type = AssetParamType()
                            })

                        ) {
                            val expense = it.arguments?.getParcelable<Expense>(Constants.PARAM_EXPENSE)
                            if (expense != null) {
                                ExpenseDetailsScreen(expense, navController)
                            }
                        }

                    }
                }
            }

        }
    }
}
