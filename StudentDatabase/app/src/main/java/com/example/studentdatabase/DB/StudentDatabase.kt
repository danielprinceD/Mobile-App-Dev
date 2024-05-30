package com.example.studentdatabase.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Student::class] , version = 1 , exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun getStudentDao() : StudentDAO

    companion object {
        var Instance : StudentDatabase ?= null
        fun getInstance(context : Context) : StudentDatabase{
            synchronized(this){
              var instance = Instance
                if(instance==null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext ,
                        StudentDatabase::class.java,
                        "Student_Database"
                    ).build()
                }
                return instance
            }
        }
    }

}