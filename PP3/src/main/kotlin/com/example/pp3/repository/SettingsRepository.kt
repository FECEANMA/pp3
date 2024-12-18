package com.example.pp3.repository

import com.example.pp3.entity.Settings
import org.springframework.data.jpa.repository.JpaRepository

interface SettingsRepository: JpaRepository<Settings, Long> {
}