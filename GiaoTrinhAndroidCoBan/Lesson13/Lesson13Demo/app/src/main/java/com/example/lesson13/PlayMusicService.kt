package com.example.lesson13

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class PlayMusicService : Service() {

    companion object{
        final const val PLAY_MUSIC ="PLAY_MUSIC"
        final const val STOP_MUSIC ="STOP_MUSIC"
    }

    lateinit var mediaPlayer : MediaPlayer

    override fun onBind(intent: Intent): IBinder? {
      return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("PlayMusicService","PlayMusicService")
        mediaPlayer = MediaPlayer.create(this, R.raw.muonroimasaocon_sontung)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.e("PlayMusicService",intent.action.toString())
        when(intent.action){
            PLAY_MUSIC -> mediaPlayer.start()
            STOP_MUSIC -> mediaPlayer.stop()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}