package com.example.pp3.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .authorizeRequests { auth ->
                auth
                    .requestMatchers("/api/users/login", "/api/users/register").permitAll()  // Permitir el acceso a login y register
                    .anyRequest().authenticated()  // Las demás rutas requieren autenticación
            }
            .formLogin { it.disable() }
            .httpBasic { it.disable() }
        return http.build()
    }
}
