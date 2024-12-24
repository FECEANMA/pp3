package com.example.pp3.repository

import com.example.pp3.entity.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository: JpaRepository<Users, Long> {
    fun findByEmail(email: String): Users?
}