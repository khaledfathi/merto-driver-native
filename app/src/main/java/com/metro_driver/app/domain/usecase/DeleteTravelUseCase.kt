package com.metro_driver.app.domain.usecase

import com.metro_driver.app.domain.repository.TravelRepository

class DeleteTravelUseCase(val repository: TravelRepository) {
    fun deleteById(id: Int) {

    }

    fun deleteByDate(data: String , onSuccess:()->Unit , onFailure: (error:String)->Unit) {

    }
}