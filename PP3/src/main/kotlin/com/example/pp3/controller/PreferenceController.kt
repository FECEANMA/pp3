package com.example.pp3.controller

import com.example.pp3.dto.PreferencesDto
import com.example.pp3.entity.Preferences
import com.example.pp3.service.PreferencesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/preferences")

class PreferenceController {
    @Autowired
    lateinit var preferencesService: PreferencesService

    @GetMapping
    fun getAllPreferences(): ResponseEntity<List<Preferences>> {
        val preferences = preferencesService.getPreferences()
        return ResponseEntity.ok(preferences)
    }
    @PostMapping
    fun createPreference(@RequestBody preferencesDto: PreferencesDto): ResponseEntity<Preferences> {
        val createdPreference = preferencesService.save(preferencesDto)
        return ResponseEntity.ok(createdPreference)
    }

    @PutMapping("/{id}")
    fun updatePreference(
        @PathVariable id: Long,
        @RequestBody preferencesDto: PreferencesDto
    ): ResponseEntity<Preferences> {
        val updatedPreference = preferencesService.update(id, preferencesDto)
        return ResponseEntity.ok(updatedPreference)
    }

    @DeleteMapping("/{id}")
    fun deletePreference(@PathVariable id: Long): ResponseEntity<Void> {
        preferencesService.delete(id)
        return ResponseEntity.noContent().build()
    }
}