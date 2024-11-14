package com.metro_driver.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.metro_driver.core.database.entity.TravelModel

@Dao
interface TravelDao {
    @Query("SELECT * FROM travels")
    fun getAll(): List<TravelModel>

    @Query("SELECT * FROM travels WHERE id = (:id)")
    fun getById(id: Int): TravelModel?

    @Query("SELECT * FROM travels WHERE strftime('%Y-%m-%d', date) = (:date) ORDER BY strftime('%H:%M:%S', time) ASC ")
    fun getByDate(date: String): List<TravelModel>

    @Query("SELECT * FROM travels WHERE date BETWEEN (:startDate) AND (:endDate) ORDER BY date ASC")
    fun getByPeriod(startDate: String, endDate: String): List<TravelModel>

    @Insert()
    fun insertAll(vararg users: TravelModel):List<Long>

    @Update
    fun updateAll(vararg users: TravelModel): Int

    @Query("DELETE FROM travels WHERE id = (:id)")
    fun deleteById(id: Int): Int

    @Query("DELETE FROM travels WHERE  strftime('%Y-%m-%d', date) = (:date)")
    fun deleteByDate(date: String): Int
}