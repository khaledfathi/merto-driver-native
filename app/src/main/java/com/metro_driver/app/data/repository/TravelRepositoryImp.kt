package com.metro_driver.app.data.repository

import android.content.Context
import com.metro_driver.app.domain.entity.TravelEntity
import com.metro_driver.app.domain.repository.TravelRepository
import com.metro_driver.core.database.LocalDatabase
import com.metro_driver.core.database.entity.TravelModel

class TravelRepositoryImp(private val context: Context) : TravelRepository {
    override fun getByDate(date: String): List<TravelEntity> {
        val records = mutableListOf<TravelEntity>()
        LocalDatabase.getInstance(context).travelDao().getByDate(date)
            .forEach {
                records.add(
                    TravelEntity(
                        id = it.id,
                        date = it.date,
                        time = it.time,
                        travelNumber = it.travelNumber,
                        unitA = it.unitA,
                        unitB = it.unitB,
                        unitC = it.unitC
                    )
                )
            }
        return records
    }

    override fun getByPeriod(startDate: String, endDate: String): List<TravelEntity> {
        val records = mutableListOf<TravelEntity>()
        LocalDatabase.getInstance(context).travelDao().getByPeriod(startDate, endDate)
            .forEach {
                records.add(
                    TravelEntity(
                        id = it.id,
                        date = it.date,
                        time = it.time,
                        travelNumber = it.travelNumber,
                        unitA = it.unitA,
                        unitB = it.unitB,
                        unitC = it.unitC
                    )
                )
            }
        return records
    }

    override fun insert(data: TravelEntity): Long {
        return LocalDatabase.getInstance(context).travelDao().insertAll(
            TravelModel(
                date = data.date,
                time = data.time,
                travelNumber = data.travelNumber,
                unitA = data.unitA,
                unitB = data.unitB,
                unitC = data.unitC,
            )
        ).first()
    }

    override fun update(data: TravelEntity): Int {
        return LocalDatabase.getInstance(context).travelDao().updateAll(
            TravelModel(
                id = data.id ?: 0,
                date = data.date,
                time = data.time,
                travelNumber = data.travelNumber,
                unitA = data.unitA,
                unitB = data.unitB,
                unitC = data.unitC,
            )
        )
    }

    override fun deleteById(id: Int): Int {
        return LocalDatabase.getInstance(context).travelDao().deleteById(id)
    }

    override fun deleteByDate(date: String): Int {
        return LocalDatabase.getInstance(context).travelDao().deleteByDate(date)
    }
}