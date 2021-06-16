package com.toandev.lesson11

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.toandev.lesson11.room.User
import com.toandev.lesson11.room.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SharedPreferenceActivity : AppCompatActivity() {
    private val userNameKey = "userNameKey123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)
        val sharePref = getSharedPreferences("ToanMobile", Context.MODE_PRIVATE)
        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val getTextEditext = findViewById<EditText>(R.id.edtUser).text.toString()
            sharePref.edit().putString(userNameKey, getTextEditext).apply()
        }

        findViewById<Button>(R.id.btnLoad).setOnClickListener {
            sharePref.getString(userNameKey, null)?.apply {
                findViewById<TextView>(R.id.txtData).text = this
            }
        }
    }


}