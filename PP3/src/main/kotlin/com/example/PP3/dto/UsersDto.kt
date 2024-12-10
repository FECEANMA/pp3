package com.example.PP3.dto

import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

class UsersDto {
    @NotNull
    @NotBlank(message = "Username is required")
    var username: String? = null

    @NotNull
    @NotBlank(message = "Email is required")
    var email: String? = null
}