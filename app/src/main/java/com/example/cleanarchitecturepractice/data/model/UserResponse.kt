package com.example.cleanarchitecturepractice.data.model

import com.example.cleanarchitecturepractice.domain.model.User

data class UserResponse(
    val avatar: String,
    val creationAt: String,
    val email: String,
    val id: Int,
    val name: String,
    val password: String,
    val role: String,
    val updatedAt: String
){
    fun toDomain(): User{
        return User(
            id = this.id,
            email = this.email,
            name = this.name,
            password = this.password,
            avatar = this.avatar,
            role = this.role,
            creationAt = this.creationAt,
            updatedAt = this.updatedAt
        )
    }
}