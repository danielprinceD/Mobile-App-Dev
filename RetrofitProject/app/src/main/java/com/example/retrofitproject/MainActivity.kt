package com.example.retrofitproject

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofitproject.databinding.ActivityMainBinding
import retrofit2.Response
import kotlin.math.sin

class Toaster{
    companion object
    {
        fun toast( context : Context,text : String){
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }
    }
}

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getRequestFormService()


    }
    private fun getRequestFormService(){
        val serviceInstance = RetrofitInstance.getInstance().create(RetrofitService::class.java)
        val liveData : LiveData<Response<Data>> = liveData {
            val response  = serviceInstance.getItemsByUserId(2)
            emit(response)
            val response2  = serviceInstance.getItemsByUserId(3)
            emit(response2)
        }

        val singleData : LiveData<Response<DataItem>> = liveData{
            val response = serviceInstance.getDataById(10)
            emit(response)
        }
        singleData.observe(this, Observer {
            val res = it.body()!!
            Toaster.toast(this,"User -> ${res.userId} \n Body - > ${res.body}")
        })

        liveData.observe(this, Observer {
            val items = it.body()?.listIterator()
            if(items!=null){
                while(items.hasNext()){
                    val curr = items.next()
                    val result : String = "${curr.id}. {  \n  id : ${curr.id} , \n\n title : ${curr.title} , \n\n body : ${curr.body} \n\n , userId : ${curr.userId} } \n\n"
                    binding.textView.append(result)
                }
            }
        })
    }

}