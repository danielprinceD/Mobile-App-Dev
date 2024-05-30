package com.example.studentdatabase.DB

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    val id : Int ,
    @ColumnInfo(name = "NAME")
    val name : String,
    @ColumnInfo(name = "EMAIL")
    val email : Email,
)