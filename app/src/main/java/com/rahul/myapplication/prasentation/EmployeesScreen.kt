package com.rahul.myapplication.prasentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.rahul.myapplication.data.local.Employee
import com.rahul.myapplication.viewmodel.EmployeeViewModel


@Composable
fun EmployeesScreen(viewModel: EmployeeViewModel, modifier: Modifier) {
    val employees = viewModel.employees.collectAsLazyPagingItems()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(employees.itemCount){index ->
            val employee = employees[index]
            if (employee != null){
                EmployeeItem(employee)
            }
        }
    }
}


@Composable
fun EmployeeItem(employee: Employee){
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = employee.url,
            contentDescription = "Profile Image",
            modifier = Modifier.size(48.dp).clip(CircleShape)
        )
        Spacer(modifier = Modifier.padding(12.dp))
        Column {
            Text(text = employee.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Id: ${employee.id}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}