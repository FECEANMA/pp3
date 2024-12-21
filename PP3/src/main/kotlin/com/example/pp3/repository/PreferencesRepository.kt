package com.example.pp3.repository

import com.example.pp3.entity.Preferences
import org.springframework.data.jpa.repository.JpaRepository

interface PreferencesRepository: JpaRepository<Preferences, Long> {
}