package com.example.pp3.util

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

class JwtAuthenticationFilter(
    private val jwtTokenProvider: JwtTokenProvider
) : BasicAuthenticationFilter(null) {

    @Throws(ServletException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain
    ) {
        val token = getJwtFromRequest(request)

        if (token != null && jwtTokenProvider.validateToken(token)) {
            val email = jwtTokenProvider.extractSubject(token)
            val authentication = UsernamePasswordAuthenticationToken(
                email, null, listOf() // Puedes agregar roles si es necesario
            )
            SecurityContextHolder.getContext().authentication = authentication
        }

        chain.doFilter(request, response)
    }

    private fun getJwtFromRequest(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader("Authorization")
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7) // Extract the token from the "Bearer " prefix
        } else null
    }
}