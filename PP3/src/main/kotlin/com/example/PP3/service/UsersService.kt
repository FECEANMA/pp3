package com.example.PP3.service

import com.example.PP3.dto.UsersDto
import com.example.PP3.entity.Users
import com.example.PP3.mapper.UsersMapper
import com.example.PP3.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsersService {
    @Autowired
    lateinit var usersRepository: UsersRepository
    fun getUsers(): List<Users> {
        return usersRepository.findAll()
    }
    fun save(usersDto: UsersDto): Users{
        var users = UsersMapper.toEntity(usersDto)
        return usersRepository.save(users)
    }
}