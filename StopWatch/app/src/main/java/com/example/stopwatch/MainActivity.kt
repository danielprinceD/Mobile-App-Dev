package com.example.stopwatch

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.stopwatch.databinding.ActivityMainBinding
import com.example.stopwatch.TimerService.Companion.CURRENT
import com.example.stopwatch.TimerService.Companion.UPDATE
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var serviceIntent : Intent
    private var time = 0.0
    private var isStarted : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        serviceIntent = Intent(applicationContext , TimerService::class.java)
        registerReceiver(updateTime, IntentFilter(UPDATE))
        binding.apply {
            startBtn.setOnClickListener{startOrStop()}
            resetBtn.setOnClickListener{reset()}
        }
    }
    private fun startOrStop(){
        if(isStarted) stop()
        else start()
    }
    private fun start(){
        binding.startBtn.text = "Stop"
        serviceIntent.putExtra(CURRENT , time)
        startService(serviceIntent)
        isStarted = true
    }
    private fun stop(){
        binding.startBtn.text = "Start"
        stopService(serviceIntent)
        isStarted = false
    }
    private fun reset(){
        binding.startBtn.text = "Start"
        isStarted = false
        stopService(serviceIntent)
        time = 0.0
        binding.timeView.text = "00:00:00"

    }
    private val updateTime : BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent) {
            val timing = intent.getDoubleExtra(CURRENT , 0.0)
            time = timing
            binding.timeView.text = timeFormatter(timing)
        }
    }
    private fun timeFormatter(time : Double) : String{
        val timeInt = time.roundToInt()
        val hour = timeInt % 86400 / 3600
        val min = timeInt % 86400 % 3600 /60
        val sec = timeInt % 86400 % 3600 % 60

        return String.format("%02d:%02d:%02d", hour , min , sec)
    }
}