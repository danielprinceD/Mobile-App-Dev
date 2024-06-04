package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG , "Service Started" )
        return START_STICKY
    }

    override fun onDestroy() {
        Log.i(TAG , "Service Stopped" )
        super.onDestroy()
    }


    companion object {
        const val TAG = "MyService"
    }
}