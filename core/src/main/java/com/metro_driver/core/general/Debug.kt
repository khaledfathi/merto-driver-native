package com.metro_driver.core.general

import android.util.Log

class Debug {
    companion object {
        fun print(msg: Any, tag: String = "debug") {
            Log.d(tag, msg.toString())
        }
    }
}