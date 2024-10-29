package com.metro_driver.app.domain.usecase

import com.metro_driver.app.domain.repository.TravelRepository

class GetTravelUseCase(private val repository: TravelRepository) {

    suspend fun getByDate(date: String, onSuccess: () -> Unit, onFailure: (error: String) -> Unit) {
        try {
            repository.getByDate(date)
            onSuccess()
        } catch (e: Exception) {
            onFailure(e.message.toString())
        }
    }

    suspend fun getByPeriod(
        startDate: String,
        endDate: String,
        onSuccess: () -> Unit,
        onFailure: (error: String) -> Unit
    ) {
        try {
            repository.getByPeriod(startDate, endDate)
            onSuccess()
        } catch (e: Exception) {
            onFailure(e.message.toString())
        }
    }
}