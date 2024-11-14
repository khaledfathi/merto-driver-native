package com.metro_driver.app.domain.usecase

import com.metro_driver.app.domain.entity.TravelEntity
import com.metro_driver.app.domain.repository.TravelRepository

class GetTravelUseCase(private val repository: TravelRepository) {

    suspend fun getByDate(
        date: String,
        onSuccess: (records: List<TravelEntity>) -> Unit,
        onFailure: (error: String) -> Unit
    ) {
        try {
            onSuccess(repository.getByDate(date))
        } catch (e: Exception) {
            onFailure(e.message.toString())
        }
    }

    suspend fun getByPeriod(
        startDate: String,
        endDate: String,
        onSuccess: (records: List<TravelEntity>) -> Unit,
        onFailure: (error: String) -> Unit
    ) {
        try {
            onSuccess(repository.getByPeriod(startDate, endDate))
        } catch (e: Exception) {
            onFailure(e.message.toString())
        }
    }
}