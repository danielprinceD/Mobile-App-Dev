package com.example.studentdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Database
import com.example.studentdatabase.DB.Student
import com.example.studentdatabase.DB.StudentDAO
import kotlinx.coroutines.launch

class StudentViewModel(private val dao : StudentDAO) : ViewModel() {

    val students = dao.getAll()
    fun insertData(student : Student){
        viewModelScope.launch {
            dao.insertData(student)
        }
    }
    fun deleteData(student : Student){
        viewModelScope.launch {
            dao.deleteData(student)
        }
    }
    fun updateData(student : Student){
        viewModelScope.launch {
            dao.updateData(student)
        }
    }
}
