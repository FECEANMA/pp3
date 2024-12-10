package com.example.PP3.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "events")
class Events {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var userId: String? = null
    var eventType: String? = null
    @Column(name = "event_time")
    var eventTime: LocalDateTime? = null

    @PrePersist
    fun onCreate() {
        eventTime = LocalDateTime.now()
    }

    @PreUpdate
    fun onUpdate() {
        eventTime = LocalDateTime.now()
    }
}