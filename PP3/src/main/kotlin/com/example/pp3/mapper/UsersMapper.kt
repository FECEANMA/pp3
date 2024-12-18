package com.example.pp3.mapper

import com.example.pp3.dto.UsersDto
import com.example.pp3.entity.Users

object UsersMapper {
    fun toEntity(usersDto: UsersDto): Users{
        val users = Users()
        users.username = usersDto.username
        users.email = usersDto.email
        users.phone = usersDto.phone

        if (usersDto.password != null) {
            users.password = usersDto.password
        }
        return users
    }
    fun toDto (users: Users): UsersDto {
        val usersDto = UsersDto()
        usersDto.username = users.username
        usersDto.email = users.email
        usersDto.phone = users.phone
        return usersDto
    }
}