package com.example.firstapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var getName = intent.getStringExtra("NAME")
        val textView = findViewById<TextView>(R.id.textView2)
        textView.text = "Hey, ${getName} ! You got 1 month Free trial"
    }
    override fun onStart() {
        super.onStart()
        Log.i("Life" , "Activity 2 Started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Life" , "Activity 2 Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Life" , "Activity 2 Paused")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Life" , "Activity 2 Stopped")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i("Life" , "Activity 2 Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Life" , "Activity 2 Destroy")
    }
}