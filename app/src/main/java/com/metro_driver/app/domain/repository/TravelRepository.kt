package com.metro_driver.app.domain.repository

import com.metro_driver.app.domain.entity.TravelEntity

interface TravelRepository {
    /**
     * Get all travel records
     *
     * @param date date in ISO format ( yyyy-MM-dd hh:mm:ss)
     * @return list of [TravelEntity]
     */
    fun getByDate(date:String):List<TravelEntity>

    /**
     * Get travel record filter by date
     *
     * @param startDate start date
     * @param endDate end date
     * @return list of [TravelEntity]
     */
    fun getByPeriod(startDate:String, endDate:String):List<TravelEntity>

    /**
     * Insert new travel record
     *
     * @param data travel record as [TravelEntity] object
     * @return the id of inserted record
     */
    fun insert(data:TravelEntity):Long

    /**
     * Update travel fields
     *
     * @param data new record to be updated
     * @return count of record updated
     */
    fun update(data:TravelEntity):Int

    /**
     * Delete specific travel record by its id
     *
     * @param id travel record id
     * @return count of deleted record
     */
    fun deleteById(id:Int):Int

    /**
     * Delete travel records , filtered by date
     *
     * @param date date in ISO Format
     * @return count of deleted records
     */
    fun deleteByDate(date:String):Int
}