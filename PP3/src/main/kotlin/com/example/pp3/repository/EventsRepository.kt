package com.example.pp3.repository

import com.example.pp3.entity.Events
import org.springframework.data.jpa.repository.JpaRepository

interface EventsRepository: JpaRepository<Events, Long> {
}