package com.toandev.lesson11

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.toandev.lesson11.room.User
import com.toandev.lesson11.room.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RoomActivity : AppCompatActivity() {
    private val db by lazy { UserDatabase(application).userDao() }
    private val dbUserInfo by lazy { UserDatabase(application).userInfoDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val userName = findViewById<EditText>(R.id.edtUser).text.toString()
            val info = findViewById<EditText>(R.id.edtPassword).text.toString()

            if (userName.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    val user: User = db.getUser(userName)
                    if (user == null) {
                        db.insertUser(User(userName = userName, info = info))
                    }
                }
            }
        }

        findViewById<Button>(R.id.btnLoad).setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                val userName = findViewById<EditText>(R.id.edtUser).text.toString()
                val user: User = db.getUser(userName)
                if (user != null) {
                    withContext(Dispatchers.Main) {
                        findViewById<TextView>(R.id.txtData).text = user.toString()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        findViewById<TextView>(R.id.txtData).text = "User Info not found"
                    }
                }
            }
        }

        findViewById<Button>(R.id.btnShowListUser).setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                val listUser = dbUserInfo.deleteAllUser()
                withContext(Dispatchers.Main) {
                    findViewById<TextView>(R.id.txtData).text = listUser.toString()
                }
            }
        }
    }


}