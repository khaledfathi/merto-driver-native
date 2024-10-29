package com.metro_driver.core.preferences_datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

class CoreDataStore(val context: Context) {
    companion object{
        val datastore  = preferencesDataStore(name = "settings_pref")
    }

}