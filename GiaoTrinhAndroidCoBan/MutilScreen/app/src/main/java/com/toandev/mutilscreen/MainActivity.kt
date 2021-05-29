package com.toandev.mutilscreen

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txt1 = findViewById<View>(R.id.displayMetrics) as TextView
        val txt2 = findViewById<View>(R.id.displayMetrics1) as TextView
        val txt3 = findViewById<View>(R.id.displayMetrics2) as TextView
        val txt4 = findViewById<View>(R.id.displayMetrics3) as TextView
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        val dpHeight = metrics.heightPixels / metrics.density
        //Hàm phân loại màn hình
        val dpWidth = metrics.widthPixels / metrics.density //***********

        txt1.text = "Width/density:$dpWidth   Height/density:$dpHeight"

        val displayMetrics1 = this@MainActivity.resources.displayMetrics
        val dpHeight1 = displayMetrics1.heightPixels.toFloat()
        val dpWidth1 = displayMetrics1.widthPixels.toFloat()
        txt2.text = "widthPixels:$dpWidth1   heightPixels:$dpHeight1"

        val displayMetrics2 = this@MainActivity.resources.displayMetrics
        val density = displayMetrics2.density
        val densityDpi = displayMetrics2.densityDpi.toFloat()
        txt3.text = "density:$density   densityDpi:$densityDpi"
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels
        val dens = dm.densityDpi
        val wi = width.toDouble() / dens.toDouble()
        val hi = height.toDouble() / dens.toDouble()
        val x = Math.pow(wi, 2.0)
        val y = Math.pow(hi, 2.0)
        val screenInches = Math.sqrt(x + y)
        txt4.text = "screenInches:$screenInches"
    }
}