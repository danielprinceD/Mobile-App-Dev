package com.example.stopwatch

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.util.Timer
import java.util.TimerTask

class TimerService : Service() {
    private val timer = Timer()
    override fun onBind(intent: Intent?): IBinder? = null
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val current = intent.getDoubleExtra(CURRENT , 0.0)
        timer.scheduleAtFixedRate(MyTimerTask(current) , 0 , 1000)
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    private inner class MyTimerTask(var time : Double) : TimerTask(){
        override fun run() {
            val intent = Intent(UPDATE)
            time++
            intent.putExtra(CURRENT , time)
            sendBroadcast(intent)
        }
    }

    companion object {
        const val CURRENT = "current time"
        const val UPDATE = "updated time"
    }
}