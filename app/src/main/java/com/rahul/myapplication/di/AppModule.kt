package com.rahul.myapplication.di

import android.content.Context
import com.rahul.myapplication.data.AppDatabase
import com.rahul.myapplication.data.local.EmployeeRepositoryImpl
import com.rahul.myapplication.domain.EmployeeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase{
        return AppDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideRepository(database: AppDatabase, @ApplicationContext context: Context): EmployeeRepository{
        return EmployeeRepositoryImpl(database,context)
    }
}