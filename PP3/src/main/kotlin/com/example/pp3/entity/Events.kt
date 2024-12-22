package com.example.pp3.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

enum class EventType {
    FUGA_DETECTADA,          // Fuga de gas detectada
    VENTILADOR_ENCENDIDO,    // Ventilador encendido
    VALVULA_CERRADA,         // Válvula de gas cerrada automáticamente
    SISTEMA_REESTABLECIDO    // Sistema restablecido
}

@Entity
@Table(name = "events")
class Events {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    var eventType: EventType? = null


    @Column(name = "gas_concentration", precision = 10, scale = 2)
    var gasConcentration: BigDecimal? = null

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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    var user: Users? = null
}