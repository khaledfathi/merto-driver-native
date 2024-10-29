package com.metro_driver.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("settings")
data class SettingsModel(
    @ColumnInfo("key") @PrimaryKey val key: String,
    @ColumnInfo("value") val value: String
)