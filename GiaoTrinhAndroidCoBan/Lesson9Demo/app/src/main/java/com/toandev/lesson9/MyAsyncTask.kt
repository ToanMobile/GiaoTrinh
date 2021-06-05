package com.toandev.lesson9

import android.app.Activity
import android.os.AsyncTask
import android.os.SystemClock
import android.widget.TextView
import android.widget.Toast

class MyAsyncTask(var contextParent: Activity) : AsyncTask<Void?, Int?, Void?>() {
    override fun onPreExecute() {
        super.onPreExecute()
        //Hàm này sẽ chạy đầu tiên khi AsyncTask này được gọi
        //Ở đây mình sẽ thông báo quá trình load bắt đâu "Start"
        Toast.makeText(contextParent, "Start", Toast.LENGTH_SHORT).show()
    }

    protected fun onProgressUpdate(vararg values: Int) {
        //Hàm thực hiện update giao diện khi có dữ liệu từ hàm doInBackground gửi xuống
        super.onProgressUpdate()
    }

    override fun onPostExecute(aVoid: Void?) {
        super.onPostExecute(aVoid)
        //Hàm này được thực hiện khi tiến trình kết thúc
        //Ở đây mình thông báo là đã "Finshed" để người dùng biết
        Toast.makeText(contextParent, "Okie, Finished", Toast.LENGTH_SHORT).show()
    }

    override fun doInBackground(vararg params: Void?): Void? {
        for (i in 0..100) {
            SystemClock.sleep(100)
            //khi gọi hàm này thì onProgressUpdate sẽ thực thi
            publishProgress(i)
        }
        return null
    }
}