package com.toandev.lesson5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = mutableListOf<UserModel>()
        for (i in 0..100) {
            list.add(UserModel(name = "Toan"+ i, age = i))
        }
        findViewById<RecyclerView>(R.id.rcvUser).adapter = UserAdapter(list)
    }
}