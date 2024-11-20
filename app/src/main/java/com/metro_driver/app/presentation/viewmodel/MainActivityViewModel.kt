package com.metro_driver.app.presentation.viewmodel

import android.content.Context
import android.icu.text.SimpleDateFormat
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metro_driver.app.R
import com.metro_driver.app.data.pref_datastore.Preferences
import com.metro_driver.app.data.repository.TravelRepositoryImp
import com.metro_driver.app.domain.entity.TravelEntity
import com.metro_driver.app.domain.usecase.AddTravelUseCase
import com.metro_driver.app.domain.usecase.DeleteTravelUseCase
import com.metro_driver.app.domain.usecase.GetTravelUseCase
import com.metro_driver.app.domain.usecase.UpdateTravelUseCase
import com.metro_driver.app.presentation.activity.dataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

class MainActivityViewModel : ViewModel() {
    private var isNightMode = false
    private var _themeIcon = R.drawable.night_mode_icon

    //
    var currentSelectedDate: LocalDate = LocalDate.now()

    //travel List
    private val _travelList = MutableLiveData<List<TravelEntity>>(listOf())
    val travelList: LiveData<List<TravelEntity>> = _travelList

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
            _themeIcon = R.drawable.day_mode_icon
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {

            _themeIcon = R.drawable.night_mode_icon
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    fun getTravelsByDate(
        context: Context,
        date: LocalDate,
        onSuccess: (records: List<TravelEntity>) -> Unit,
        onFailure: (error: String) -> Unit
    ) {
        currentSelectedDate = date
        val dateFormated = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        viewModelScope.launch(Dispatchers.IO) {
            GetTravelUseCase(TravelRepositoryImp(context)).getByDate(
                date = dateFormated.format(date).toString(),
                onSuccess = { records ->
                    viewModelScope.launch {
                        _travelList.value = records
                        onSuccess(records)
                    }
                },
                onFailure = { error ->
                    viewModelScope.launch {
                        onFailure(error)
                    }
                }
            )
        }
    }

    fun addTravel(
        context: Context,
        travel: String,
        unitA: String,
        unitB: String,
        unitC: String,
        notes: String,
        onSuccess: (recordId: Long) -> Unit,
        onFailure: (error: String) -> Unit
    ) {
        val travelRecord = TravelEntity(
            date = currentSelectedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            time = SimpleDateFormat("HH:mm:ss", Locale.US).format(Date().time).toString(),
            travelNumber = try {
                travel.toInt()
            } catch (e: Exception) {
                null
            },
            unitA = try {
                unitA.toInt()
            } catch (e: Exception) {
                null
            },
            unitB = try {
                unitB.toInt()
            } catch (e: Exception) {
                null
            },
            unitC = try {
                unitC.toInt()
            } catch (e: Exception) {
                null
            },
            notes = notes
        )
        viewModelScope.launch(Dispatchers.IO) {
            AddTravelUseCase(TravelRepositoryImp(context)).add(
                travelRecord,
                onSuccess = { records ->
                    viewModelScope.launch {
                        onSuccess(records)
                    }
                },
                onFailure = { error ->
                    viewModelScope.launch {
                        onFailure(error)
                    }

                }
            )
        }
    }

    fun updateTravel(
        context: Context,
        id: String,
        travel: String,
        date:String,
        time:String,
        unitA: String,
        unitB: String,
        unitC: String,
        notes: String,
        onSuccess: (updatedCount: Int) -> Unit,
        onFailure: (error: String) -> Unit
    ) {
        val travelRecord = TravelEntity(
            id = id.toInt(),
            date = date,
            time = time,
            travelNumber = try {
                travel.toInt()
            } catch (e: Exception) {
                null
            },
            unitA = try {
                unitA.toInt()
            } catch (e: Exception) {
                null
            },
            unitB = try {
                unitB.toInt()
            } catch (e: Exception) {
                null
            },
            unitC = try {
                unitC.toInt()
            } catch (e: Exception) {
                null
            },
            notes = notes
        )
        viewModelScope.launch(Dispatchers.IO) {
            UpdateTravelUseCase(TravelRepositoryImp(context)).update(
                travel = travelRecord,
                onSuccess = { updatedCount ->
                    viewModelScope.launch {
                        onSuccess(updatedCount)
                    }
                },
                onFailure = { error ->
                    viewModelScope.launch {
                        onFailure(error)
                    }
                }
            )
        }
    }

    fun deleteTravel(
        context: Context,
        id: String,
        onSuccess: (deletedCount: Int) -> Unit,
        onFailure: (error: String) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            DeleteTravelUseCase(TravelRepositoryImp(context)).deleteById(
                id = id.toInt(),
                onSuccess = { deletedCount ->
                    viewModelScope.launch {
                        onSuccess(deletedCount)
                    }
                },
                onFailure = { error ->
                    viewModelScope.launch {
                        onFailure(error)
                    }
                },
            )
        }
    }

    /*##### Setters/Getters #####*/
    @DrawableRes
    fun getThemeIcon(): Int {
        return _themeIcon
    }
}