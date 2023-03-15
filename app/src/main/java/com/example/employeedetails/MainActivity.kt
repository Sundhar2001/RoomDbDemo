package com.example.employeedetails

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.employeedetails.adapter.EmployeeAdapter
import com.example.employeedetails.model.EmployeeModel

class MainActivity : AppCompatActivity(){

    private lateinit var employeeAdapter: EmployeeAdapter
    private lateinit var viewModel: EmployeeModel
    private lateinit var recyclerView: RecyclerView

     lateinit var saveButton: Button
     lateinit var name: TextView
     lateinit var email: TextView

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

         recyclerView = findViewById<RecyclerView>(R.id.employee_list_recyclerview)

        employeeAdapter = EmployeeAdapter(this)
        recyclerView.adapter = employeeAdapter
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        viewModel = ViewModelProvider(this)[EmployeeModel::class.java]
        viewModel.getAllEmployeeObservers().observe(this, Observer {
            employeeAdapter.setListData(it)
            employeeAdapter.notifyDataSetChanged()
        })

        saveButton = findViewById<Button>(R.id.btn_save)
        name = findViewById<Button>(R.id.et_name)
        email = findViewById<Button>(R.id.et_email)

        saveButton.setOnClickListener {
            val textName = name.text.toString()
            val textEmail = email.text.toString()


                if (textName.isEmpty() || textEmail.isEmpty()) {
                    Toast.makeText(this, "Please enter details", Toast.LENGTH_SHORT).show()
                } else {

                    val employee = EmployeeEntity(0, textName, textEmail)
                    viewModel.insertEmployeeInfo(employee)
                    Toast.makeText(this, "Successfully saved ", Toast.LENGTH_SHORT).show()
                }

            name.text = ""
            email.text = ""
        }
    }

}