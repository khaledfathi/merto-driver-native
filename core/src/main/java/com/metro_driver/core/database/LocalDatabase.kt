package com.metro_driver.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.metro_driver.core.database.dao.SettingsDao
import com.metro_driver.core.general.DATABASE_NAME
import com.metro_driver.core.database.dao.TravelDao
import com.metro_driver.core.database.entity.SettingsModel
import com.metro_driver.core.database.entity.TravelModel

@Database(
    entities = [
        TravelModel::class,
        SettingsModel::class
    ],
    version = 1
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun travelDao(): TravelDao
    abstract fun SettingsDao(): SettingsDao

    companion object {
        private var _db: LocalDatabase? = null
        fun getInstance(context: Context): LocalDatabase {
            return _db ?: synchronized("lock") {
                Room.databaseBuilder(
                    context,
                    LocalDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
        }
    }
}