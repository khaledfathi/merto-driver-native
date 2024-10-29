package com.metro_driver.app.data.pref_datastore

import androidx.datastore.preferences.core.booleanPreferencesKey

class Preferences {
    companion object{
        val NIGHT_MODE = booleanPreferencesKey("night_mode")
    }
}