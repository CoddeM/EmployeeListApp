package com.rahul.myapplication.domain.usecase

import com.rahul.myapplication.domain.EmployeeRepository
import javax.inject.Inject

class LoadCsvDataUseCase @Inject constructor(
    private val repo: EmployeeRepository
) {
    suspend operator fun invoke(){
        repo.loadCsvData()
    }
}