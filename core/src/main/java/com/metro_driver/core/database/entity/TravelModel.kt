package com.metro_driver.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("travels")
data class TravelModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo("date") val date: String? = null,
    @ColumnInfo("time") val time: String? = null,
    @ColumnInfo("travel_number") val travelNumber: Int? = null,
    @ColumnInfo("unit_a") val unitA: Int? = null,
    @ColumnInfo("Unit_b") val unitB: Int? = null,
    @ColumnInfo("Unit_c") val unitC: Int? = null,
    @ColumnInfo("notes") val notes: String? = null,
)