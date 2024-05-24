package com.example.bmi

import android.graphics.Color
import android.os.Bundle
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
    private  lateinit var calculate : Button
    private lateinit var height : EditText
    private lateinit var weight : EditText
    private lateinit var condition : TextView
    private lateinit var resultValue : TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate = findViewById<Button>(R.id.button)
        height = findViewById<EditText>(R.id.editTextText)
        weight = findViewById<EditText>(R.id.editTextText2)

        calculate.setOnClickListener{ calculator()}

        }

        private fun calculator() {
            if (validator()) {
                var h = height.text.toString().toDouble()
                var w = weight.text.toString().toDouble()
                h /= 100
                h *= h
                try {
                    var bmi = w / h
                    condition = findViewById<TextView>(R.id.textView6)
                    resultValue = findViewById<TextView>(R.id.textView7)
                    resultValue.text = "value : ${bmi.toString().substring(0 , 5)}"
                    if (bmi < 18.5) {
                        condition.setTextColor(Color.parseColor("#d80032"))
                        condition.text = "UnderWeight"
                    } else if (bmi >= 18.5 && bmi < 25) {
                        condition.setTextColor(Color.parseColor("#FFFFFFFF"))
                        condition.text = "Normal Weight"
                    } else if (bmi >= 25 && bmi < 30) {
                        condition.setTextColor(2)
                        condition.setTextColor(Color.parseColor("#f17300"))
                        condition.text = "Over Weight"
                    } else {
                        condition.setTextColor(Color.parseColor("#d80032"))
                        condition.text = "Obese"
                    }
                } catch (ex: Exception) {
                    Toast.makeText(this , "$ex" , Toast.LENGTH_SHORT).show()
                }
            }

        }

        private fun validator() : Boolean{
            try{
                if(height.text.isNullOrEmpty() || height.text.toString().toDouble() == 0.0)
                {
                    Toast.makeText(this, "Please enter height" , Toast.LENGTH_SHORT).show()
                    return false
                }
                if(weight.text.isNullOrEmpty() || weight.text.toString().toDouble() == 0.0)
                {
                    Toast.makeText(this, "Please enter weight" , Toast.LENGTH_SHORT).show()
                    return false
                }
                var temp =  height.text.toString().toDouble()
                temp = weight.text.toString().toDouble()
            }
            catch (e : Exception){
                Toast.makeText(this, "Please enter Valid Input" , Toast.LENGTH_SHORT).show()
                return false
            }
            return  true
        }

    }