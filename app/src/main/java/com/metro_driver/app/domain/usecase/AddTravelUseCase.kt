package com.metro_driver.app.domain.usecase

import com.metro_driver.app.domain.entity.TravelEntity
import com.metro_driver.app.domain.repository.TravelRepository

class AddTravelUseCase(val repository: TravelRepository) {
    fun add(travel:TravelEntity , onSuccess:()->Unit , onFailure: (error:String)->Unit) {

    }
}