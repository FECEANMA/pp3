package com.example.PP3.dto

import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

class EventsDto {
    @NotNull
    @NotBlank(message = "Event Type is required")
    var eventType: String? = null
}