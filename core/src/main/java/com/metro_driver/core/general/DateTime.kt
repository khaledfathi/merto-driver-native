package com.metro_driver.core.general

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateTime {

    fun getCurrentISODate(): String {
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    }

    fun getCurrentISOTime(): String {
        return SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
    }

    fun getCurrentISODateTime(): String {
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
    }

}