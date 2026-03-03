package com.rahul.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.rahul.myapplication.domain.usecase.GetEmployeesUseCase
import com.rahul.myapplication.domain.usecase.LoadCsvDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(
    private val getEmployeesUseCase: GetEmployeesUseCase,
    private val loadCsvDataUseCase: LoadCsvDataUseCase
): ViewModel() {

    val employees = getEmployeesUseCase.invoke().cachedIn(viewModelScope)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadCsvDataUseCase()
        }
    }
}