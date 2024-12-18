package com.example.pp3.service

import com.example.pp3.dto.SettingsDto
import com.example.pp3.entity.Settings
import com.example.pp3.mapper.SettingsMapper
import com.example.pp3.repository.SettingsRepository
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