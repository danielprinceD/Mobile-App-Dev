package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.myapplication.databinding.ActivityMainBinding


class Toaster{
    companion object{
        fun toast(c : Context , m : String){
            Toast.makeText(c,m,Toast.LENGTH_SHORT).show()
        }
    }
}


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val channelId = "com.example.myapplication.ch1"
    private var notificationManager : NotificationManager ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createChannel(channelId, "Channel 1" , "this is Channel 1")
        binding.button.setOnClickListener {
            try{
            displayNotification()
            }
            catch (ex : Exception){
                Toaster.toast(this, "Not")
            }
        }

    }
    private fun displayNotification(){
        val notificationId = 10
        val notification = NotificationCompat.Builder(this@MainActivity , channelId)
            .setContentTitle("Alert Message")
            .setContentText("This is Important Message")
            .setSmallIcon(android.R.mipmap.sym_def_app_icon)
            .setPriority(1)
            .setAutoCancel(true)
            .build()
        notificationManager?.notify(notificationId , notification)

    }
    private fun createChannel(id : String, name : String, desc : String) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager?.createNotificationChannel(
                NotificationChannel(
                    id,
                    name,
                    NotificationManager.IMPORTANCE_HIGH
                ).apply { description = desc })

        }
    }

}