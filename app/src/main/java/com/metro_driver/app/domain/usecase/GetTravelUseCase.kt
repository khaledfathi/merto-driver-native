package com.metro_driver.app.domain.usecase

import com.metro_driver.app.domain.repository.TravelRepository

class GetTravelUseCase(val repository: TravelRepository) {

    fun getByDate(date: String, onSuccess: () -> Unit, onFailure: (error: String) -> Unit) {

    }
}