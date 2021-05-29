package com.toandev.lesson2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.toandev.lesson2.ui.home.HomeFragment
import com.toandev.lesson2.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
           /* supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()*/
            supportFragmentManager.beginTransaction().replace(R.id.fragment1, HomeFragment()).commit()


            /////
            supportFragmentManager.beginTransaction().replace(R.id.fragment2, MainFragment.newInstance()).commit()
        }
        findViewById<Button>(R.id.btnOpenDemoActivity).setOnClickListener {
            val intent = Intent(this, DemoActivity::class.java)
            startActivity(intent)
        }
    }
}