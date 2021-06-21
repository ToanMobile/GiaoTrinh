package com.example.lesson13.view

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson13.R
import com.example.lesson13.model.MyMedia
import com.example.lesson13.model.SongAdapter
import com.example.lesson13.service.MusicService

class MainActivity : AppCompatActivity() {
    private val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123

    var intentService: Intent? = null
    val myMedia = MyMedia(this)
    var isPlay = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermission()
        intentService = Intent(this, MusicService::class.java)
    }

    @SuppressLint("WrongConstant")
    fun initRecycleView() {
        val listSong = myMedia.getListSong()
        findViewById<RecyclerView>(R.id.recycleViewMain).adapter = SongAdapter(listSong) { music ->
            if (!isPlay) {
                isPlay = true
                intentService?.apply {
                    action = MusicService.SEND_PLAY_ACTION
                    putExtra(MusicService.URL_PATH_MUSIC, music.path)
                    startService(this)
                }
                findViewById<TextView>(R.id.txtMusicTitle).text = music.title
            } else {
                isPlay = false
                intentService?.apply {
                    action = MusicService.SEND_STOP_ACTION
                    startService(this)
                }
                findViewById<TextView>(R.id.txtMusicTitle).text = "Không có bài đang chơi!"
            }
        }
    }
/*

    override fun onSongClick(path: String) {
        Log.e("App.TAG:isPlay=", isPlay.toString() + "path==" + path)
        if (!isPlay) {
            intentService?.apply {
                action = MusicService.SEND_PLAY_ACTION
                putExtra(MusicService.URL_PATH_MUSIC, path)
                startService(this)
            }
            isPlay = true
        } else {
            isPlay = false
            intentService?.action = MusicService.SEND_STOP_ACTION
            startService(intentService)
        }
    }
*/

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE
            )
        } else {
            initRecycleView()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    initRecycleView()
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    finish()
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }
}
