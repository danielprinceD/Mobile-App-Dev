package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.MyService.Companion.NAME
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.MyService.Companion.TAG


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var serviceIntent = Intent(this ,MyService::class.java )
        binding.apply {
            startBtn.setOnClickListener{
                Log.i(TAG , "Service Starting......." )
                serviceIntent.putExtra(NAME , "Daniel")
                startService(serviceIntent)
            }
            stopBtn.setOnClickListener{
                Log.i(TAG , "Service Stopping........" )
                stopService(serviceIntent)
            }
        }
    }
}