package com.example.pp3.service

import com.example.pp3.dto.PreferencesDto
import com.example.pp3.entity.Preferences
import com.example.pp3.mapper.PreferencesMapper
import com.example.pp3.repository.PreferencesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PreferencesService {
    @Autowired
    lateinit var settingsRepository: PreferencesRepository
    fun getSettings(): List<Preferences> {
        return settingsRepository.findAll()
    }
    fun save(settingsDto: PreferencesDto): Preferences {
        val settings = PreferencesMapper.toEntity(settingsDto)
        return settingsRepository.save(settings)
    }
}