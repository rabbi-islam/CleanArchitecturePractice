package com.example.cleanarchitecturepractice.data.api

import com.example.cleanarchitecturepractice.data.model.UserResponse
import retrofit2.http.GET

interface UserApiService {
    @GET("api/v1/users")
    suspend fun getUsers(): List<UserResponse>
}