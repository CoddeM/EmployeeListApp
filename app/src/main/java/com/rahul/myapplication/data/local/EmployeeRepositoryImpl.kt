package com.rahul.myapplication.data.local

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.room.withTransaction
import com.rahul.myapplication.R
import com.rahul.myapplication.data.AppDatabase
import com.rahul.myapplication.domain.EmployeeRepository
import kotlinx.coroutines.flow.Flow

class EmployeeRepositoryImpl(
    private val database: AppDatabase,
    private val context: Context
): EmployeeRepository {
    override fun getAllEmployees(): Flow<PagingData<Employee>> {
        return Pager(
            config = PagingConfig(pageSize = 30, enablePlaceholders = false),
            pagingSourceFactory = {database.employeeDao().getPagedEmployees()}
        ).flow
    }

    override suspend fun loadCsvData() {
        if (database.employeeDao().getEmployeesCount() == 0){
            database.withTransaction {
                context.resources.openRawResource(R.raw.employees).bufferedReader().useLines { lines->
                    val segment = mutableListOf<Employee>()

                    lines.drop(1).forEach { line->
                        val parts = line.split(",")
                        if (parts.size >= 3){
                            segment.add(
                                Employee(
                                    id = parts[0].toInt(),
                                    name = parts[1],
                                    url = parts [2]
                                )
                            )
                        }

                        if (segment.size >= 500){
                            database.employeeDao().insertAllEmployees(segment)
                            segment.clear()
                        }
                    }
                    if (segment.isNotEmpty()){
                        database.employeeDao().insertAllEmployees(segment)
                    }
                }
            }
        }
    }
}