package com.example.recyclerview

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecycleHolder(private val view : View ): RecyclerView.ViewHolder(view) {
    fun bind( array : Array<String> , pos : Int){
    var myTextView = view.findViewById<TextView>(R.id.textView)
        myTextView.text = array[pos]
        view.setOnClickListener{
            Toast.makeText(view.context , "You have selected : ${array[pos]}", Toast.LENGTH_SHORT).show()
        }
    }

}