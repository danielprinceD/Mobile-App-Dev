package com.example.studentdatabase.DB

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDAO {
    @Insert
    suspend fun insertData(student : Student)

    @Update
    suspend fun updateData(student: Student)

    @Delete
    suspend fun deleteData(student: Student)

    @Query("select * from Student")
    fun getAll() : LiveData<List<Student>>
}