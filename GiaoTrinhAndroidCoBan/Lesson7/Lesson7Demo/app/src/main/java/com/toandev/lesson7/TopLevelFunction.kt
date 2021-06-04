package com.toandev.lesson7

import java.text.SimpleDateFormat
import java.util.*

fun getCurrentDate(): String {
    val date = Date()
    val dateFormat = "dd/MM/yyyy"
    val sdf = SimpleDateFormat(dateFormat)
    return sdf.format(date)
}


fun getName(): String {
    return "Toan Dev"
}

