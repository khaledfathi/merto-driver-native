package com.metro_driver.app.domain.usecase

import com.metro_driver.app.domain.repository.TravelRepository

class DeleteTravelUseCase(private val repository: TravelRepository) {
    suspend fun deleteById(id: Int , onSuccess: (deletedCount:Int) -> Unit , onFailure: (error: String) -> Unit) {
        try {
            onSuccess(repository.deleteById(id))
        }catch (e:Exception){
            onFailure(e.message.toString())
        }
    }

    suspend fun deleteByDate(date: String , onSuccess:(deletedCount:Int)->Unit , onFailure: (error:String)->Unit) {
        try {
            onSuccess(repository.deleteByDate(date))
        }catch (e:Exception){
            onFailure(e.message.toString())
        }
    }
}