package com.example.cleanarchitecturepractice.domain.usecase

import com.example.cleanarchitecturepractice.domain.model.User
import com.example.cleanarchitecturepractice.domain.repository.UserRepository

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): List<User> {
        return userRepository.getUser()
    }
}