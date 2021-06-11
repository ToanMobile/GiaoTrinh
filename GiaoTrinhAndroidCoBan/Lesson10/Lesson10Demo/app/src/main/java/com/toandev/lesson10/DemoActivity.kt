package com.toandev.lesson10

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.Logger


class DemoActivity : AppCompatActivity() {

    companion object {
        private const val DATA_1 ="test1"
        private const val DATA_2 ="test2"

        @JvmStatic
        fun newInstance(context: Context, param1: String, param2: String) {
            val intent= Intent(context, DemoActivity::class.java)
            intent.putExtra(DATA_1,param1)
            intent.putExtra(DATA_2, param2)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        findViewById<TextView>(R.id.test1).text = intent.getStringExtra(DATA_1)
        findViewById<TextView>(R.id.test2).text = intent.getStringExtra(DATA_2)
    }

    override fun onStart() {
        super.onStart()
        Logger.e("onStart")
    }

    override fun onPause() {
        super.onPause()
        Logger.e("onPause")
    }

    override fun onResume() {
        super.onResume()
        Logger.e("onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Logger.e("onRestart")
    }

    override fun onStop() {
        super.onStop()
        Logger.e("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.e("onDestroy")
    }
}
