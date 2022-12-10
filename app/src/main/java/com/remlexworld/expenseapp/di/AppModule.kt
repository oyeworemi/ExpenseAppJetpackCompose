package com.remlexworld.expenseapp.di

import com.remlexworld.expenseapp.common.Constants
import com.remlexworld.expenseapp.data.remote.ExpenseApi
import com.remlexworld.expenseapp.data.repository.ExpenseRepositoryImpl
import com.remlexworld.expenseapp.domain.repository.ExpenseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    @Singleton
    fun provideExpensesApi(): ExpenseApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExpenseApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(newsApi: ExpenseApi): ExpenseRepository {
        return ExpenseRepositoryImpl(newsApi)
    }


}