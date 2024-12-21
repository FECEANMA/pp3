package com.example.pp3.dto

import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

class PreferencesDto {
    @NotNull
    @NotBlank(message = "Fan Activated is required")
    var fanActivated: Boolean? = false
    @NotNull
    @NotBlank(message = "Fan State is required")
    var fanState: Boolean? = false
}