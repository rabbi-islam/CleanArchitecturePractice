package com.example.cleanarchitecturepractice.di

import com.example.cleanarchitecturepractice.data.api.UserApiService
import com.example.cleanarchitecturepractice.data.repository.UserRepositoryImpl
import com.example.cleanarchitecturepractice.domain.repository.UserRepository
import com.example.cleanarchitecturepractice.domain.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideUserApi(): UserApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.escuelajs.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideUserRepository(userApi: UserApiService): UserRepository {
        return UserRepositoryImpl(userApi)
    }

    @Singleton
    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCase(userRepository)
    }
}