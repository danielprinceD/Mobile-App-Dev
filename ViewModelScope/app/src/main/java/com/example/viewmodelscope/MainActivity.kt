package com.example.viewmodelscope

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val MVS = ViewModelProvider(this)[MAViewModel::class.java]
        MVS.model()
        MVS.liveData?.observe(this , Observer {
           us-> us.forEach {
                Log.i("Listerr" , "${it.id} ${it.name} ${it.age}" )
            }
        })
    }
}