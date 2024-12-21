package com.example.pp3.dto

import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

class UsersDto {
    @NotNull
    @NotBlank(message = "Username is required")
    var username: String? = null

    @NotNull
    @NotBlank(message = "Email is required")
    var email: String? = null

    @jakarta.validation.constraints.NotNull(message = "Phone is required")
    var phone: String? = null


    var password: String? = null
}