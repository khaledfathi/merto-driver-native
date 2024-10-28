package com.metro_driver.app.domain.usecase

import com.metro_driver.app.domain.entity.TravelEntity
import com.metro_driver.app.domain.repository.TravelRepository

class UpdateTravelUseCase(val repository: TravelRepository) {
    fun update(data:TravelEntity , onSuccess:()->Unit , onFailure: (error:String)->Unit){
    }

}