package com.example.PP3.service

import com.example.PP3.dto.SettingsDto
import com.example.PP3.entity.Settings
import com.example.PP3.mapper.SettingsMapper
import com.example.PP3.repository.SettingsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SettingsService {
    @Autowired
    lateinit var settingsRepository: SettingsRepository
    fun getSettings(): List<Settings> {
        return settingsRepository.findAll()
    }
    fun save(settingsDto: SettingsDto): Settings {
        var settings = SettingsMapper.toEntity(settingsDto)
        return settingsRepository.save(settings)
    }
}