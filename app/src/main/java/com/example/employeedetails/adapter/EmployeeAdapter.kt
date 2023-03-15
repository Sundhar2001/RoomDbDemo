package com.example.employeedetails.adapter

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.employeedetails.EmployeeEntity
import com.example.employeedetails.R


class EmployeeAdapter(context: Context): RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>() {

    private var items = mutableListOf<EmployeeEntity>()

    fun setListData(data: List<EmployeeEntity>){
        this.items = data as MutableList<EmployeeEntity>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeAdapter.MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.employee_list_item,parent,false)
        return MyViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {

        Log.d("Size: " , Int.toString())
        return items.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: EmployeeAdapter.MyViewHolder, position: Int) {

        holder.bind(items[position])
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
         private val tvName: TextView = view.findViewById(R.id.tv_employee_name)
        private val tvEmail: TextView = view.findViewById(R.id.tv_employee_email)

        fun bind(data: EmployeeEntity){

                tvName.text = data.name
                tvEmail.text = data.email

        }
    }

}