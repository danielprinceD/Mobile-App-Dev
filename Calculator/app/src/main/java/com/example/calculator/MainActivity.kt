package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var text : TextView ?= null
    var history : TextView ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById<TextView>(R.id.textView)
        history = findViewById(R.id.history)
        text?.text = ""
        history?.text = "History"

    }
    fun Clicked(view : View)
    {
        text?.append((view as Button).text)
//        Toast.makeText(this , "${(view as Button).text  }" ,Toast.LENGTH_SHORT ).show()
    }
    fun Clear(view : View)
    {
        text?.text = ""
    }

    fun LastOut(view : View){
        val str = text?.text
        str?.let {
        if(str.length >= 1)
        text?.text = text?.text?.substring(0 , str.length-1)
        }
    }
    fun operation(view : View)
    {
            if(text?.text?.length!! >= 1)
            {
                var check : Char ?= text?.text?.last()
                if(!check?.equals('-')!! && !check?.equals('*')!! && !check?.equals('/')!! && !check?.equals('+')!! && !check?.equals('%')!! && !check?.equals('.')!! )
                    text?.append((view as Button).text)
                if(text?.text?.last()!! <= '9' && text?.text?.last()!! >= '0'){
                    text?.append((view as Button).text)
                }

            }
            else if((view as Button).text.equals("-"))
            {
                text?.append((view as Button).text)
            }
            else if((view as Button).text.equals("."))
            {
                text?.append("0.")
            }
    }
    fun Equal(view : View) {
        var operator: MutableList<Char> = mutableListOf()
        var numbers: MutableList<String> = mutableListOf()
        try{


        if (text?.text?.length!! >= 1) {

            if (text?.text?.first() != '-')
                operator.add('+')
            var textLength = text?.text?.length
            var temp = ""
            text?.text?.forEach {
                if (it?.equals('+')!! || it?.equals('-')!! || it?.equals('/')!! || it?.equals(
                        '%'
                    )!! || it?.equals('*')!!
                ) {
                    operator.add(it)
                    numbers.add(temp)
                    temp = ""
                } else {
                    temp += it
                }
            }
            if (!temp?.isEmpty()!!)
                numbers.add(temp)
        }
        var total = 0.0

            numbers.forEachIndexed{
                ind , it ->
                   if(operator[ind] == '+')
                       total += it.toDouble()
                if(operator[ind] == '%')
                    total %= it.toDouble()
                if(operator[ind] == '*')
                    total *= it.toDouble()
                if(operator[ind] == '/')
                    total /= it.toDouble()
                if(operator[ind] == '-')
                    total -= it.toDouble()
            }
            history?.text = text?.text
        text?.text = "$total"

        } catch (ex : Exception)
        {
        }
    }

}