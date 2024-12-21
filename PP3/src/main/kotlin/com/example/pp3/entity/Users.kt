package com.example.pp3.entity

import jakarta.persistence.*


@Entity
@Table(name = "users")
class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var username: String? = null
    var email: String? = null
    var password: String? = null
    var phone: String? = null
}