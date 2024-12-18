package com.example.pp3.mapper

import com.example.pp3.dto.SettingsDto
import com.example.pp3.entity.Settings

object SettingsMapper {
    fun toEntity(settingsDto: SettingsDto): Settings {
        var settings = Settings()
        settings.fanActivated = settingsDto.fanActivated
        settings.stateActivated = settingsDto.fanState
        return settings
    }
}