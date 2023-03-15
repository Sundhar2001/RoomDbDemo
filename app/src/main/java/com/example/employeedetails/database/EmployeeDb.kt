package com.example.employeedetails.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.employeedetails.EmployeeDao
import com.example.employeedetails.EmployeeEntity

@Database(entities = [EmployeeEntity::class], version = 1)
abstract class EmployeeDb: RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao?

    companion object{
        private var INSTANCE: EmployeeDb? = null

        fun getEmployeeDatabase(context: Context): EmployeeDb? {

            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder<EmployeeDb> (
                    context.applicationContext, EmployeeDb::class.java,"dataBase"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}