package com.example.employeedetails

import androidx.room.*

@Dao
@Entity
interface EmployeeDao {

    @Query("SELECT * FROM employeeList ORDER BY id DESC")
    fun getAllEmployeeList(): List<EmployeeEntity>

    @Insert
    fun insertEmployee(employee: EmployeeEntity?)

    @Delete
    fun deleteEmployee(employee: EmployeeEntity?)

    @Update
    fun updateEmployee(employee: EmployeeEntity?)
}