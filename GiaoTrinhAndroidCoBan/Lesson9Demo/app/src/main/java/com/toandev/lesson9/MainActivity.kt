package com.toandev.lesson9

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Logger.addLogAdapter(AndroidLogAdapter())
        //Async task
        val myAsyncTask = MyAsyncTask(this)
        myAsyncTask.execute()

        // RxKotlin
        /*Observable.just("Apple", "Orange", "Banana")
            .observeOn(Schedulers.io())
            .subscribe(
                { value -> Logger.e("Received$value") }, // onNext
                { error -> Log.e("Error:",error.toString()) },    // onError
                {
                    Logger.e("Completed!"+"OK")
                }                 //onComplete
            )

        Observable.interval(1000, TimeUnit.MILLISECONDS)
            .subscribe { Logger.e("Interval:$it") }*/
        //Coroutine
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val list = listOf("Apple", "Orange", "Banana").map { item ->
                    Logger.e("Received:$item")
                    item
                }
                Logger.e("Completed")
                withContext(Dispatchers.Main) {
                    findViewById<TextView>(R.id.txtText).setBackgroundResource(R.mipmap.ic_launcher)
                    Logger.e("Completed111111")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        CoroutineScope(Dispatchers.IO).launch {
            var count = 0
            while (true) {
                delay(1000)
                count++
                Log.e("Interval:", count.toString())
            }
        }

        CoroutineScope(Dispatchers.IO).launch {

        }
        //
    }
}