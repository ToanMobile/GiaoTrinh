package com.example.lesson13.service

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.util.Log
import com.example.lesson13.R

private const val TAG = "MusicService"
class MusicServiceRaw : Service(){
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"onCreate")
        mediaPlayer= MediaPlayer.create(this, R.raw.muonroimasaocon_sontung)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        Log.d(TAG,"onStartCommand: mediaPlayer.start()")
        mediaPlayer.start()
        return Service.START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy: ")
        mediaPlayer.stop()
    }
    private val serviceConnection= object:ServiceConnection{
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

            }

            override fun onServiceDisconnected(name: ComponentName?) {

            }
        }

}