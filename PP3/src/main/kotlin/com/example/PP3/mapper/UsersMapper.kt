package com.example.PP3.mapper

import com.example.PP3.dto.UsersDto
import com.example.PP3.entity.Users

object UsersMapper {
    fun toEntity(usersDto: UsersDto): Users{
        var users = Users()
        users.username = usersDto.username
        users.email = usersDto.email
        return users
    }
}