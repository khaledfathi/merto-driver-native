package com.metro_driver.app.domain.usecase

import com.metro_driver.app.domain.entity.TravelEntity
import com.metro_driver.app.domain.repository.TravelRepository

class AddTravelUseCase(private val repository: TravelRepository) {
    suspend fun add(
        travel: TravelEntity,
        onSuccess: (recordId: Long) -> Unit,
        onFailure: (error: String) -> Unit
    ) {
        try {
            val recordId = repository.insert(travel)
            onSuccess(recordId)
        } catch (e: Exception) {
            onFailure(e.message.toString())
        }
    }
}