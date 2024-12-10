package com.example.PP3.repository

import com.example.PP3.entity.Settings
import org.springframework.data.jpa.repository.JpaRepository

interface SettingsRepository: JpaRepository<Settings, Long> {
}