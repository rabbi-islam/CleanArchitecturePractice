package com.example.cleanarchitecturepractice.data.repository

import com.example.cleanarchitecturepractice.data.api.UserApiService
import com.example.cleanarchitecturepractice.domain.model.User
import com.example.cleanarchitecturepractice.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userApiService: UserApiService
): UserRepository {
    override suspend fun getUser(): List<User> {
        return userApiService.getUsers().map { it.toDomain() }
    }
}