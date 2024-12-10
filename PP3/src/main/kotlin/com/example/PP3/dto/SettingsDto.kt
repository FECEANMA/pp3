package com.example.PP3.dto

import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

class SettingsDto {
    @NotNull
    @NotBlank(message = "Fan Activated is required")
    var fanActivated: Boolean? = null
    @NotNull
    @NotBlank(message = "Fan State is required")
    var fanState: Boolean? = null
}