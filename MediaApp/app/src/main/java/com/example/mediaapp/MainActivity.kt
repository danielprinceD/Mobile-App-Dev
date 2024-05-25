package com.example.mediaapp

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var media : MediaPlayer ?= null
    private lateinit var seekBar : SeekBar
    private lateinit var runnable : Runnable
    private lateinit var handler: Handler
    private lateinit var remaining : TextView
    private lateinit var played : TextView
    private lateinit var pause : FloatingActionButton
    private lateinit var stop : FloatingActionButton
    private lateinit var start : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekBar = findViewById(R.id.seekBar)
        remaining = findViewById(R.id.remaining)
        played = findViewById(R.id.played)
        remaining.text = ""
        played.text = ""
        handler = Handler(Looper.getMainLooper())
        media = MediaPlayer.create(this , R.raw.intro)
        start = findViewById(R.id.fabPlay)
        stop = findViewById(R.id.fabNext)
        pause = findViewById(R.id.fabPrev)
        start.setOnClickListener{
            if(media == null){
                media = MediaPlayer.create(this , R.raw.intro)
            }
            initSeekBar()
            media?.start()
        }

        pause.setOnClickListener{ media?.pause() }

        stop.setOnClickListener {
            media?.stop()
            media?.reset()
            media?.release()
            media = null
            handler.removeCallbacks(runnable)
            seekBar.progress = 0
        }
    }
    private fun initSeekBar(){
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser)
                    media?.seekTo(progress)
                played.text = "${(media!!.currentPosition/1000)} sec"
                var rem = ( media!!.duration/1000) - (media!!.currentPosition/1000)
                remaining.text = "$rem sec"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }
        })

        seekBar.max = media!!.duration
        runnable = Runnable {
            seekBar.progress = media!!.currentPosition
            played.text = "${(media!!.currentPosition/1000)} sec"
            var rem = ( media!!.duration/1000) - (media!!.currentPosition/1000)
            remaining.text = "$rem sec"
            handler.postDelayed(runnable, 1000 )
        }
        handler.postDelayed(runnable , 1000)
    }
}