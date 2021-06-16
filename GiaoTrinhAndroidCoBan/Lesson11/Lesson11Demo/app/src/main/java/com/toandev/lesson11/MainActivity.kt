package com.toandev.lesson11
import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.*
import java.util.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var btn_save: Button? = null
    private var btn_read: Button? = null
    private var tv_show: TextView? = null
    private val fileName = "Lesson12"
    private val content = "Khoá học Android Cơ bản!"
    private val TAG = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        checkAndRequestPermissions()
    }

    private fun initView() {
        btn_save = findViewById<View>(R.id.btn_save_data) as Button
        btn_save!!.setOnClickListener(this)
        btn_read = findViewById<View>(R.id.btn_read_data) as Button
        btn_read!!.setOnClickListener(this)
        tv_show = findViewById<View>(R.id.tv_show_data) as TextView
    }

    //xin 2 quyen
    private fun checkAndRequestPermissions() {
        val permissions = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        val listPermissionsNeeded: MutableList<String> = ArrayList()
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission)
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toTypedArray(), 1)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_save_data -> saveData2()
            R.id.btn_read_data -> readData()
            else -> { }
        }
    }

    //kiểm tra bộ nhớ
    private val isExternalStorageReadable: Boolean
        get() {
            val state = Environment.getExternalStorageState()
            return Environment.MEDIA_MOUNTED == state || Environment.MEDIA_MOUNTED_READ_ONLY == state
        }

    private fun saveData() {
        //mở luồn lên = null
        var fileOutputStream: FileOutputStream? = null
        val file: File
        if (isExternalStorageReadable) {
            try {
                //tạo 1 file ở thư mục Environment.getExternalStorageDirectory(), ten file
                //có thể thuyền đường dần File("/SDcard0/,fileName);
                //bắt buộc phải đúng tên
                file = File(cacheDir, fileName)
                //show duong dan
                Log.d(TAG, "saveData: " + cacheDir.absolutePath)
                //            khởi tại cái luồn
                fileOutputStream = FileOutputStream(file)
                //ghi xún thư mục
                fileOutputStream.write(content.toByteArray())
                Toast.makeText(this, "Lưu Thành Công", Toast.LENGTH_SHORT).show()
                //đóng luồn
                //lưu mặc định ngoài cùng
                fileOutputStream.close()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } else {
            Toast.makeText(this, "Đầy Bộ Nhớ", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveData2() {
        //mở luồn lên = null
        var fileOutputStream: FileOutputStream? = null
        val file: File
        try {
            //tạo 1 file ở thư mục getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), ten file
            file = File(cacheDir, fileName)
            //show duong dan
            Log.d(TAG, "saveData: " + getExternalFilesDir(null)?.absolutePath)
            //            khởi tại cái luồn
            fileOutputStream = FileOutputStream(file)
            //ghi xún thư mục
            fileOutputStream.write(content.toByteArray())
            Toast.makeText(this, "Lưu Thành Công", Toast.LENGTH_SHORT).show()
            //đóng luồn
            //lưu mặc định ngoài cùng
            fileOutputStream.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun readData() {
        var bf: BufferedReader? = null
        var file: File? = null
        try {
            //file = File(Environment.getExternalStorageDirectory(), fileName)
            file = File(getExternalFilesDir(null), fileName)
            bf = BufferedReader(InputStreamReader(FileInputStream(file)))
            var line: String?
            //dung buffer de doc tung dong
            val buffer = StringBuffer()
            while (bf.readLine().also { line = it } != null) {
                buffer.append(line)
            }
            tv_show!!.text = buffer.toString()
            Log.d(TAG, "readData: $buffer")
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}