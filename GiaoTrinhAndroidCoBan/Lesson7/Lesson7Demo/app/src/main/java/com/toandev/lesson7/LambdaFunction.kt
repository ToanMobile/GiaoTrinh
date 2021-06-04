package com.toandev.lesson7

import android.util.Log

class LambdaFunction {
    companion object {
        val message = { str:String->
            Log.e("LambdaFunction:", str)
            Log.e("LambdaFunction:","End lambda function")
        }

        val test = { count: Int ->
            Log.e("LambdaFunction:", count.toString())
        }
    }
}