package com.example.PP3.repository

import com.example.PP3.entity.Events
import jdk.jfr.Event
import org.springframework.data.jpa.repository.JpaRepository

interface EventsRepository: JpaRepository<Events, Long> {
}