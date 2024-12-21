package com.example.pp3.service

import com.example.pp3.dto.UsersDto
import com.example.pp3.mapper.UsersMapper
import com.example.pp3.repository.UsersRepository
import com.example.pp3.util.JSendResponse
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class UsersService(
    private val usersRepository: UsersRepository,
) {


    fun getUsers(page: Int, size: Int): JSendResponse<Page<UsersDto>> {
        val pageable = PageRequest.of(page, size)
        val usersPage = usersRepository.findAll(pageable)
        val usersDtoPage = usersPage.map { UsersMapper.toDto(it) }
        return JSendResponse.success(usersDtoPage)
    }


    fun save(usersDto: UsersDto): ResponseEntity<JSendResponse<UsersDto>> {
        if (usersDto.email?.contains("@") != true) {
            return ResponseEntity.badRequest()
                .body(JSendResponse.fail("Invalid email address"))
        }

        val userEntity = UsersMapper.toEntity(usersDto)

        return try {
            val savedUser = usersRepository.save(userEntity)
            val savedUserDto = UsersMapper.toDto(savedUser)
            ResponseEntity.ok(JSendResponse.success(savedUserDto))
        } catch (e: DataIntegrityViolationException) {
            ResponseEntity.badRequest()
                .body(JSendResponse.error("User could not be saved: ${e.message}", code = 400))
        }
    }



    fun findById(userId: Long): ResponseEntity<JSendResponse<UsersDto>> {
        val user = usersRepository.findById(userId).orElseThrow {
            NoSuchElementException("User with ID $userId not found")
        }
        return ResponseEntity.ok(JSendResponse.success(UsersMapper.toDto(user)))
    }


    fun update(userId: Long, usersDto: UsersDto): ResponseEntity<JSendResponse<UsersDto>> {
        val existingUser = usersRepository.findById(userId).orElseThrow {
            NoSuchElementException("User with ID $userId not found")
        }

        // Actualiza solo los campos necesarios
        existingUser.username = usersDto.username ?: existingUser.username
        existingUser.email = usersDto.email ?: existingUser.email
        existingUser.phone = usersDto.phone ?: existingUser.phone

        val updatedUser = usersRepository.save(existingUser)
        return ResponseEntity.ok(JSendResponse.success(UsersMapper.toDto(updatedUser)))
    }


    fun delete(userId: Long): ResponseEntity<JSendResponse<String>> {
        return if (usersRepository.existsById(userId)) {
            usersRepository.deleteById(userId)
            ResponseEntity.ok(JSendResponse.success("User with ID $userId has been deleted"))
        } else {
            ResponseEntity.badRequest().body(JSendResponse.error("User with ID $userId not found"))
        }
    }
}
