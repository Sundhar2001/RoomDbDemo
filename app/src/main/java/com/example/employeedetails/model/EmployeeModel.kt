package com.example.employeedetails.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.employeedetails.EmployeeEntity
import com.example.employeedetails.database.EmployeeDb

class EmployeeModel(app: Application): AndroidViewModel(app) {

    var allEmployee: MutableLiveData<List<EmployeeEntity>> = MutableLiveData()

    fun getAllEmployeeObservers(): MutableLiveData<List<EmployeeEntity>>{
        return allEmployee
    }

    private fun getAllEmployee(){
        val employeeDao = EmployeeDb.getEmployeeDatabase((getApplication()))?.employeeDao()
        val list = employeeDao?.getAllEmployeeList()
        allEmployee.postValue(list)
    }

    fun insertEmployeeInfo(entity: EmployeeEntity){
        val employeeDao = EmployeeDb.getEmployeeDatabase(getApplication())?.employeeDao()
        employeeDao?.insertEmployee(entity)
        getAllEmployee()

    }

    fun updateEmployeeInfo(entity: EmployeeEntity){
        val employeeDao = EmployeeDb.getEmployeeDatabase(getApplication())?.employeeDao()
        employeeDao?.updateEmployee(entity)
        getAllEmployee()
    }

    fun deleteEmployeeInfo(entity: EmployeeEntity){
        val employeeDao = EmployeeDb.getEmployeeDatabase(getApplication())?.employeeDao()
        employeeDao?.deleteEmployee(entity)
        getAllEmployee()
    }
}