package com.metro_driver.app.domain.usecase

import com.metro_driver.app.domain.entity.TravelEntity
import com.metro_driver.app.domain.repository.TravelRepository

class UpdateTravelUseCase(private val repository: TravelRepository) {
    suspend fun update(
        travel: TravelEntity,
        onSuccess: (updatedCount: Int) -> Unit,
        onFailure: (error: String) -> Unit
    ) {
        try {
            onSuccess(repository.update(travel))
        } catch (e: Exception) {
            onFailure(e.message.toString())
        }
    }

}