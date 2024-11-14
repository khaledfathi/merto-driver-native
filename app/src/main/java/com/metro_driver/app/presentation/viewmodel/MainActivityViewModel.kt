package com.metro_driver.app.presentation.viewmodel

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metro_driver.app.R
import com.metro_driver.app.data.pref_datastore.Preferences
import com.metro_driver.app.data.repository.TravelRepositoryImp
import com.metro_driver.app.domain.entity.TravelEntity
import com.metro_driver.app.domain.usecase.AddTravelUseCase
import com.metro_driver.app.presentation.activity.dataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivityViewModel : ViewModel() {
    private var isNightMode = false
    var themIcon = R.drawable.night_mode_icon
    fun addTravel(
        context: Context, travel: TravelEntity,
        onSuccess: (recordId: Long) -> Unit,
        onFailure: (error: String) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            AddTravelUseCase(TravelRepositoryImp(context)).add(
                travel = travel,
                onSuccess = onSuccess,
                onFailure = onFailure,
            )
        }
    }

    fun toggleNightAndDayMode(context: Context) {
        runBlocking {
            context.dataStore.edit { settings ->
                isNightMode = settings[Preferences.NIGHT_MODE] ?: false
                settings[Preferences.NIGHT_MODE] = !isNightMode
            }
        }
        setNightModeState(context)
    }

    fun setNightModeState(context: Context) {
        //read state of night mode from datastore
        isNightMode = runBlocking {
            context.dataStore.data.map { pref ->
                pref[Preferences.NIGHT_MODE] ?: false
            }.first()
        }

        if (isNightMode) {
            themIcon = R.drawable.day_mode_icon
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {

            themIcon = R.drawable.night_mode_icon
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}