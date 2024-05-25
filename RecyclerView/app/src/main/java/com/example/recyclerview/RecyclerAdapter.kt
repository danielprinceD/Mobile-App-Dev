package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<MyRecycleHolder>() {
    var array = arrayOf("Hello" , "Ok" ,"Bye" , "Yes " , "Hmm" , "Tell" , "Me" , "Joke" , "Its so Easy" , "Any App" , "Is this that ?" , "Okay")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecycleHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_view , parent , false)
        return MyRecycleHolder(listItem)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: MyRecycleHolder, position: Int) {
        holder.bind(array , position)
    }
}