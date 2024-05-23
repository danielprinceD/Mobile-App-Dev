package com.example.firstapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var share : SharedPreferences
    private lateinit var static: String
    private lateinit var button2 : Button
    private lateinit var editor : SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        share = getSharedPreferences("MyData" , MODE_PRIVATE)
        editor = share.edit()

        Log.i("Life" , "Activity Created")
        setContentView(R.layout.activity_main)
        var button1 = findViewById<Button>(R.id.button)
        button2 = findViewById<Button>(R.id.button2)
        button2.visibility = View.INVISIBLE
        var textView = findViewById<TextView>(R.id.textView)
        var inputField = findViewById<EditText>(R.id.editTextText)
        static = ""

        button1.setOnClickListener{
            if(!inputField.text.trim().isEmpty())
            {
                static = inputField.text.toString()
                textView.text = "Welcome, ${inputField.text.trim()}"
                button2.visibility = View.VISIBLE
            }
            else
                Toast.makeText(this@MainActivity , "Please enter your name " , Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener{
            val intent = Intent(this , SecondActivity::class.java)
            intent.putExtra("NAME" , static.trim())
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Life" , "Activity Started")
    }

    override fun onResume() {
        super.onResume()
        static = share.getString("Name" , "Guest").toString()
        var name = findViewById<TextView>(R.id.textView)
        name.setText("Welcome $static")
        if(static.isNotEmpty())
            button2.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()
        Log.i("Life" , "Activity Paused")
        editor.apply{
            putString("Name" , static)
            commit()
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i("Life" , "Activity Stopped")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i("Life" , "Activity Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Life" , "Activity Destroy")
    }
}