package com.rahul.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rahul.myapplication.data.local.Employee
import com.rahul.myapplication.data.local.EmployeesDao


@Database(entities = [Employee::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun employeeDao(): EmployeesDao

    //a singleton for db so that it is not instantiated multiple places

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "employee_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}