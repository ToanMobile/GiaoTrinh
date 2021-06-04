package com.toandev.lesson7

import android.util.Log

class HigherOrderFunction {

    fun showWelcome(strWelcome: String, myfunc: (String) -> Unit) {
        Log.e("showWelcome=", "Welcome to Kotlin tutorial at ")
        myfunc(strWelcome)
    }

    fun returnMeAddFunction(a: Int, b: Int): Int {
        return a + b
    }

    fun returnMeAddFunction(a: Int, b: Int, myfunc: (String) -> Unit) {
        val sum = a.div(b)
        myfunc(sum.toString())
    }
}