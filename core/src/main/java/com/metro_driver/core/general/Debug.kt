package com.metro_driver.core.general

import android.util.Log

fun debugPrint(msg: Any, tag: String = "debug") {
    Log.d(tag, msg.toString())
}