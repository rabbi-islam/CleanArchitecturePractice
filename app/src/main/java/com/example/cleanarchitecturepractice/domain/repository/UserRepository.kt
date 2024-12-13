package com.example.cleanarchitecturepractice.domain.repository

import com.example.cleanarchitecturepractice.domain.model.User

interface UserRepository {
   suspend fun getUser(): List<User>
}