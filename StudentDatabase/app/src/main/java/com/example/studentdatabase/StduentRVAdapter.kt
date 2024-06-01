package com.example.studentdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentdatabase.DB.Student

class StudentRVAdapter : RecyclerView.Adapter<StudentRVHolder>() {

    private val studentList : MutableList<Student> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentRVHolder {
        val holder = LayoutInflater.from(parent.context).inflate(R.layout.list_item , parent , false)
        return StudentRVHolder(holder)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentRVHolder, position: Int) {
        holder.bind(studentList[position])
    }

    fun setList(studs : List<Student>){
        studentList.clear()
        studentList.addAll(studs)
    }
}

class StudentRVHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    fun bind(student : Student){
        val nameField : TextView = itemView.findViewById(R.id.textView3)
        val emailField : TextView = itemView.findViewById(R.id.textView4)
        nameField.text = student.name
        emailField.text = student.email
    }
}