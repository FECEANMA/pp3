package com.example.PP3.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "settings")
class Settings {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "settings")
    var id: Long? = null
    var fanActivated: Boolean? = null
    var stateActivated: Boolean? = null
    @Column(name = "last_update_time")
    var lastUpdateTime: LocalDateTime? = null

    @PrePersist
    fun onCreate() {
        lastUpdateTime= LocalDateTime.now()
    }

    @PreUpdate
    fun onUpdate() {
        lastUpdateTime = LocalDateTime.now()
    }
}