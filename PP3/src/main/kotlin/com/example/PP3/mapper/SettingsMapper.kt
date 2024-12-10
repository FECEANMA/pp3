package com.example.PP3.mapper

import com.example.PP3.dto.SettingsDto
import com.example.PP3.entity.Settings

object SettingsMapper {
    fun toEntity(settingsDto: SettingsDto): Settings {
        var settings = Settings()
        settings.fanActivated = settingsDto.fanActivated
        settings.stateActivated = settingsDto.fanState
        return settings
    }
}