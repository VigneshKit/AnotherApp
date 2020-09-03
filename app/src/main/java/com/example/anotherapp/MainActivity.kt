package com.example.anotherapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var player:MediaPlayer
    lateinit var myBroadcastReceiver:BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var intentFilter = IntentFilter("com.example.Batch8")
        myBroadcastReceiver = object: BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                player = MediaPlayer.create(context, R.raw.siren)
                player.isLooping = true
                player.start()
            }
        }
        registerReceiver(myBroadcastReceiver, intentFilter)
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadcastReceiver)
        player.stop()
    }
}