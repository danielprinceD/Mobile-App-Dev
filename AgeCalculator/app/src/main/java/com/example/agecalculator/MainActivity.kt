package com.example.agecalculator

import java.time.Period
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dateView = findViewById<TextView>(R.id.dateEdit)
        val button = findViewById<Button>(R.id.button)
        val minView = findViewById<TextView>(R.id.minute)
        val age = findViewById<TextView>(R.id.textView4)
        button.setOnClickListener{datePicker(dateView , minView , age)}
    }
    private fun datePicker( dateView : TextView  , minView : TextView  , ageView : TextView){
        val calInstance = Calendar.getInstance()
        val year  = calInstance.get(Calendar.YEAR)
        val month = calInstance.get(Calendar.MONTH)
        val day = calInstance.get(Calendar.DAY_OF_MONTH)

        val datePick = DatePickerDialog(this , DatePickerDialog.OnDateSetListener { _ , year, month, dayOfMonth ->
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val date = sdf.parse("$dayOfMonth/${month + 1}/$year".toString())
                    var dateMin = date.time / 60000
                val current = sdf.parse(sdf.format(System.currentTimeMillis())).time / 60000
                dateView.text = "$dayOfMonth/${month + 1}/$year"
                minView.text = "In Minutes : ${current - dateMin}"

                val ld = LocalDate.now()
                val dob = if (month + 1 < 10 )LocalDate.parse("$year-0${month+1}-$dayOfMonth") else LocalDate.parse("$year-${month+1}-$dayOfMonth")
                val age = Period.between(dob , ld).years

                ageView.text = "Age : ${age}"

              } , year , month , day)
        datePick.datePicker.maxDate = System.currentTimeMillis() - (24 * 60 * 60  * 1000 )
        datePick.show()

    }
}
