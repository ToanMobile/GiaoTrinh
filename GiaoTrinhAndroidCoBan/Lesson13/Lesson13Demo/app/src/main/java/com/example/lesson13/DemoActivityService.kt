package com.example.lesson13

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DemoActivityService : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        //Start service
        val intent = Intent(this, PlayMusicService::class.java)
        startService(intent)

        findViewById<Button>(R.id.btnPlay).setOnClickListener {
            intent.action = PlayMusicService.PLAY_MUSIC
            startService(intent)
        }

        findViewById<Button>(R.id.btnStop).setOnClickListener {
            intent.action = PlayMusicService.STOP_MUSIC
            startService(intent)
        }
    }
}