package com.rahul.myapplication.domain

import androidx.paging.PagingData
import com.rahul.myapplication.data.local.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    fun getAllEmployees(): Flow<PagingData<Employee>>
    suspend fun loadCsvData()
}