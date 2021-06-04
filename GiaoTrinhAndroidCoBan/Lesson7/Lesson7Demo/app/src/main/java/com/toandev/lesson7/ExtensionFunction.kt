package com.toandev.lesson7

import android.util.Log

fun String.upperFirstLetter(): String {
    return this.first().lowercase().plus(this.substring(1))
}

fun String.upperFirstLetterMutil(): String {
    val listString = this.split(" ")// Cắt chuỗi nếu có khoảng trống
   Log.e("upperFirstLetterMutil=", ""+ listString.toString())
    var stringNew = ""
    listString.map { string ->
        Log.e("", string)
    }
    listString.map {
        val stringFirst = it.first().uppercase()
        val newString = stringFirst.plus(it.substring(1, 2))
        stringNew += "$newString "
    }
    return stringNew
}