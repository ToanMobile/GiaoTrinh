package com.example.lesson13.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson13.R
import com.example.lesson13.service.MusicServiceRaw

class MainPlayRawActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_play_raw)
        findViewById<Button>(R.id.btnPlay).setOnClickListener {
            val intent = Intent()
            intent.setClass(this, MusicServiceRaw::class.java)
            startService(intent)
        }

        findViewById<Button>(R.id.btnStop).setOnClickListener {
            val intent = Intent()
            intent.setClass(this, MusicServiceRaw::class.java)
            stopService(intent)
        }
    }
}
