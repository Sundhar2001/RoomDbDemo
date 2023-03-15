package com.example.employeedetails

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employeeList")
data class EmployeeEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int = 0,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("email") val email: String )