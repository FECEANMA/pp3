package com.example.pp3.controller

import JSendResponse
import com.example.pp3.dto.UsersDto
import com.example.pp3.service.UsersService
import org.springframework.data.domain.Page
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UsersController(
    @Autowired private val usersService: UsersService
) {

    @GetMapping
    fun getUsers(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): JSendResponse<Page<UsersDto>> {
        val usersPage = usersService.getUsers(page, size)
        return usersPage
    }


    @PostMapping
    fun save(@RequestBody usersDto: UsersDto): ResponseEntity<JSendResponse<UsersDto>> {
        return usersService.save(usersDto)
    }


    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<JSendResponse<UsersDto>> {
        return usersService.findById(id)
    }


    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody usersDto: UsersDto): ResponseEntity<JSendResponse<UsersDto>> {
        return usersService.update(id, usersDto)
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<JSendResponse<String>> {
        return usersService.delete(id)
    }
}