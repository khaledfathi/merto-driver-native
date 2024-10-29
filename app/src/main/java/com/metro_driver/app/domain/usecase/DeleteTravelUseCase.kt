package com.metro_driver.app.domain.usecase

import com.metro_driver.app.domain.repository.TravelRepository

class DeleteTravelUseCase(private val repository: TravelRepository) {
    suspend fun deleteById(id: Int , onSuccess: () -> Unit , onFailure: (error: String) -> Unit) {
        try {
            val updatedCount = repository.deleteById(id)
            onSuccess()
        }catch (e:Exception){
            onFailure(e.message.toString())
        }
    }

    suspend fun deleteByDate(date: String , onSuccess:()->Unit , onFailure: (error:String)->Unit) {
        try {
            val updatedCount = repository.deleteByDate(date)
            onSuccess()
        }catch (e:Exception){
            onFailure(e.message.toString())
        }
    }
}