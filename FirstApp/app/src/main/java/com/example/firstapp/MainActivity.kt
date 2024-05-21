package com.example.firstapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button1 = findViewById<Button>(R.id.button)
        var button2 = findViewById<Button>(R.id.button2)
        button2.visibility = View.INVISIBLE
        var textView = findViewById<TextView>(R.id.textView)
        var inputField = findViewById<EditText>(R.id.editTextText)
        var static = ""
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
}