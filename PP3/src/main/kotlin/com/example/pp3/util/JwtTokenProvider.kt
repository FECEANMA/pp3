package com.example.pp3.util

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenProvider {

    private val secretKey = "mySecretKey" // Aquí puedes usar una clave más segura

    fun createToken(email: String): String {
        val algorithm = Algorithm.HMAC512(secretKey) // Usa el algoritmo HMAC512 para firmar el JWT

        return JWT.create()
            .withSubject(email)
            .withIssuedAt(Date())
            .withExpiresAt(Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Expira en 1 hora
            .sign(algorithm)
    }

    fun validateToken(token: String): Boolean {
        return try {
            val algorithm = Algorithm.HMAC512(secretKey)
            val verifier = JWT.require(algorithm)
                .build()

            val decodedJWT = verifier.verify(token)
            !decodedJWT.expiresAt.before(Date())
        } catch (e: Exception) {
            false
        }
    }
}
