package com.rahul.myapplication.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
data class Employee (
    @PrimaryKey val id: Int,
    val name: String,
    val url: String
)