package com.toandev.lesson10

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.toandev.lesson10.fragment_normal.GreenFragment
import com.toandev.lesson10.fragment_normal.RedFragment


class MainActivity : AppCompatActivity(), ClickAction {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Logger.addLogAdapter(AndroidLogAdapter())
        findViewById<Button>(R.id.btnActivity).setOnClickListener {
            DemoActivity.newInstance(this, "10", "20")
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragment1, GreenFragment.newInstance("ToanTest", 10)).commit()

        supportFragmentManager.beginTransaction().replace(R.id.fragment2, RedFragment.newInstance()).commit()
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

    /*   override fun clickFragment(text: String) {
           Logger.e("clickFragment==$text")
       }

       override fun clickCount(count: Int) {
           val frag: GreenFragment? = supportFragmentManager.findFragmentById(R.id.fragment1) as GreenFragment?
           frag?.updateCount(count)
       }
   */
    override fun showText(test: String) {
        Logger.e("showText==$test")
        findViewById<Button>(R.id.btnActivity).text = test
    }

    override fun sumCount(count: Int) {
        val greenFragment: GreenFragment? = supportFragmentManager.findFragmentById(R.id.fragment1) as GreenFragment?
        greenFragment?.updateCount(count)
    }


}
