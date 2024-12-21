package com.example.pp3.mapper

import com.example.pp3.dto.PreferencesDto
import com.example.pp3.entity.Preferences


object PreferencesMapper {
    fun toEntity(preferencesDto: PreferencesDto): Preferences {
        return Preferences().apply {
            fanActivated = preferencesDto.fanActivated ?: false
            stateActivated = preferencesDto.fanState ?: false
        }
    }

    fun toDto(preferences: Preferences): PreferencesDto {
        return PreferencesDto().apply {
            fanActivated = preferences.fanActivated
            fanState = preferences.stateActivated
        }
    }
}