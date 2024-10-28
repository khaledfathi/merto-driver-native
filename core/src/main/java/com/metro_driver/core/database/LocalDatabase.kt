package com.metro_driver.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.metro_driver.core.DATABASE_NAME
import com.metro_driver.core.database.dao.TravelDao

@Database(entities = [TravelDao::class] , version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun TravelDao(): TravelDao
    var db: LocalDatabase? = null

    companion object {
        fun getInstance(context: Context) {
            val db = Room.databaseBuilder(
                context,
                LocalDatabase::class.java, DATABASE_NAME
            ).allowMainThreadQueries().build()
        }
    }
}