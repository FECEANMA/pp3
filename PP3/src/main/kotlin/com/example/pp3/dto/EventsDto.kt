package com.example.pp3.dto

import com.example.pp3.entity.EventType
import com.example.pp3.entity.Events
import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime

class EventsDto {
    @NotNull
    @NotBlank(message = "Event Type is required")
    var eventType: String? = null

    @NotNull
    @NotBlank(message = "Event Type is required")
    var eventTime: LocalDateTime? = null

    @NotNull
    var userId: Long?= null

}