package com.rahul.myapplication.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EmployeesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllEmployees(employee: List<Employee>)

    @Query("SELECT * FROM employees")
    fun getPagedEmployees(): PagingSource<Int, Employee>

    @Query("SELECT COUNT(id) FROM employees")
    suspend fun getEmployeesCount(): Int
}