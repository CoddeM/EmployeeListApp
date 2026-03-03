package com.rahul.myapplication.domain.usecase

import androidx.paging.PagingData
import com.rahul.myapplication.data.local.Employee
import com.rahul.myapplication.domain.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEmployeesUseCase @Inject constructor(
    private val repo: EmployeeRepository
) {
    operator fun invoke(): Flow<PagingData<Employee>>{
        return repo.getAllEmployees()
    }
}