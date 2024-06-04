package com.example.viewbinding

import android.graphics.Color
import android.os.Bundle
import android.view.View.INVISIBLE
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.transition.Visibility
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
        binding.apply {
            textView.text = "Hello Guest"
            button.visibility = INVISIBLE
            editText.doAfterTextChanged {
                if(editText.text.isNotEmpty())
                textView.text = "Hello ${editText.text}"
                else textView.text = "Hello Guest"
            }
        }
    }
}