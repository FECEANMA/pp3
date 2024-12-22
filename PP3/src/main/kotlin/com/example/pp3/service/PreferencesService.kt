package com.example.pp3.service

import com.example.pp3.dto.PreferencesDto
import com.example.pp3.entity.Preferences
import com.example.pp3.mapper.PreferencesMapper
import com.example.pp3.repository.PreferencesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PreferencesService {

    @Autowired
    lateinit var preferencesRepository: PreferencesRepository

    fun getPreferences(): List<Preferences> {
        return preferencesRepository.findAll()
    }

    fun save(preferencesDto: PreferencesDto): Preferences {
        val preferences = PreferencesMapper.toEntity(preferencesDto)
        preferences.lastUpdateTime = LocalDateTime.now() // Actualizamos el tiempo manualmente
        return preferencesRepository.save(preferences)
    }

    fun update(id: Long, preferencesDto: PreferencesDto): Preferences {
        val existingPreference = preferencesRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Preference with id $id not found") }

        val updatedPreference = existingPreference.apply {
            fanActivated = preferencesDto.fanActivated ?: fanActivated
            stateActivated = preferencesDto.fanState ?: stateActivated
        }

        return preferencesRepository.save(updatedPreference)
    }

    fun delete(id: Long) {
        if (preferencesRepository.existsById(id)) {
            preferencesRepository.deleteById(id)
        } else {
            throw IllegalArgumentException("Preference with id $id not found")
        }
    }
}
