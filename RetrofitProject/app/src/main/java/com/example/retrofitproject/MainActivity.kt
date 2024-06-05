package com.example.retrofitproject

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofitproject.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val serviceInstance = RetrofitInstance.getInstance().create(RetrofitService::class.java)
        var liveData : LiveData<Response<Data>> = liveData {
            val response  = serviceInstance.getItems()
            emit(response)
        }
        liveData.observe(this, Observer {
            val items = it.body()?.listIterator()
            if(items!=null){
                while(items.hasNext()){
                    Log.i("MYTAG" , "${items.next().id} ${items.next().title} ${items.next().body}")
                }
            }
        })
    }
}