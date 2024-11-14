package com.metro_driver.app.domain.repository

import com.metro_driver.app.domain.entity.SettingsEntity


interface SettingsRepository {
    fun addSetting(setting:SettingsEntity):Int
    fun getSetting(key:String):SettingsEntity
    fun updateSetting(setting:SettingsEntity)
}