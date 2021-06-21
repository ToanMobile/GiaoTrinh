package com.example.lesson13.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.util.Log
import com.example.lesson13.R

class MusicService : Service() {

    private var mediaPlayer: MediaPlayer? = null

    companion object {
        const val SEND_PLAY_ACTION = "play_action"
        const val SEND_STOP_ACTION = "stop_action"
        const val URL_PATH_MUSIC = "path_music"
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        stopMediaPlayer()
        Log.d("App.TAG", "Service destroyed")
    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.muonroimasaocon_sontung)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.e("App.TAG", intent.action.toString())
        Log.e("App.TAG", intent.getStringExtra(URL_PATH_MUSIC).toString())
        when (intent.action) {
            SEND_PLAY_ACTION -> {
                mediaPlayer?.apply {
                    if (!isPlaying) {
                        reset()
                        setDataSource(intent.getStringExtra(URL_PATH_MUSIC))
                        prepare()
                        start()
                    }
                }
            }
            SEND_STOP_ACTION -> {
                stopMediaPlayer()
            }
        }
        return START_STICKY
    }

    private fun stopMediaPlayer(){
        mediaPlayer?.apply {
            if (isPlaying) {
                stop()
            }
        }
    }

    fun stopService() {
        stopForeground(true)
        stopSelf()
    }

}
