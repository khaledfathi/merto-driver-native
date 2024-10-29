package com.metro_driver.app.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metro_driver.app.data.repository.TravelRepositoryImp
import com.metro_driver.app.domain.entity.TravelEntity
import com.metro_driver.app.domain.usecase.AddTravelUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    fun addTravel(
        context: Context, travel: TravelEntity,
        onSuccess: (recordId: Long) -> Unit,
        onFailure: (error: String) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO){
            AddTravelUseCase(TravelRepositoryImp(context)).add(
                travel = travel,
                onSuccess = onSuccess,
                onFailure = onFailure,
            )
        }
    }
}