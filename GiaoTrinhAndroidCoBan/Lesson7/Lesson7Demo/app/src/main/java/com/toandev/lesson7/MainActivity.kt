package com.toandev.lesson7

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("ExtensionFunction:", "khoa hoc".upperFirstLetterMutil())
        //Demo Top Level Function
        Log.e("Top Level Function:", getName())

        //Demo Lambda Function
        LambdaFunction.message("Toan demo LambdaFunction!")

        //Demo Higher Order Function
        HigherOrderFunction().showWelcome("Toan demo HigherOrderFunction!") {
            Log.e("HigherOrderFunction:", it)
        }

        Log.e("HigherOrderFunction:", HigherOrderFunction().returnMeAddFunction(10,20).toString())

        HigherOrderFunction().returnMeAddFunction(10,20) {
            Log.e("HigherOrderFunction:", it.toString())
        }

        //Demo Extension Function
        Log.e("ExtensionFunction:", "toan mobile".upperFirstLetter())
        Log.e("ExtensionFunction:", "toan mobile".upperFirstLetterMutil())
    }
}