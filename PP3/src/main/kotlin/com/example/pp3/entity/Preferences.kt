package com.example.pp3.entity
import jakarta.persistence.*
import java.time.LocalDateTime
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = "settings")
class Preferences {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "settings")
    var id: Long? = null

    @NotNull(message = "Fan activation status is required")
    @Column(name = "fan_activated")
    var fanActivated: Boolean = false

    @NotNull(message = "State activation status is required")
    @Column(name = "state_activated")
    var stateActivated: Boolean = false

    @Column(name = "last_update_time")
    var lastUpdateTime: LocalDateTime? = null

    @PrePersist
    fun onCreate() {
        lastUpdateTime = LocalDateTime.now()
    }

    @PreUpdate
    fun onUpdate() {
        lastUpdateTime = LocalDateTime.now()
    }
}
