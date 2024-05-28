package com.example.coroutineapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@OptIn(InternalCoroutinesApi::class)
class MainActivity : AppCompatActivity() {
    private lateinit var downlaod : Button
    private lateinit var count : Button
    private lateinit var tv : TextView
    private lateinit var tv2 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var counter = 1
        downlaod = findViewById(R.id.button)
        count = findViewById(R.id.button2)
        tv = findViewById(R.id.textView)
        tv2 = findViewById(R.id.tv2)
        count.setOnClickListener{
          tv.text  = counter++.toString()
        }

        downlaod.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch { downloading() }
        }
    }
    private suspend fun downloading(){
        for(i in 1..100){
            withContext(Dispatchers.Main){
            tv2.text = "${i.toString()}%"
            }
            delay(200)
        }
    }
}