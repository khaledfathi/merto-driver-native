package com.metro_driver.app.domain.repository

import com.metro_driver.app.domain.entity.TravelEntity

interface TravelRepository {
    fun getByDate(date:String):List<TravelEntity>
    fun getByPeriod(startDate:String, endDate:String):List<TravelEntity>
    fun insert(data:TravelEntity):Long
    fun update(data:TravelEntity):Int
    fun deleteById(id:Int):Int
    fun deleteByDate(date:String):Int
}