package com.example.cleanarchitecturepractice.presentation.feature.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturepractice.domain.model.User
import com.example.cleanarchitecturepractice.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    val userUseCase: GetUserUseCase
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val user: StateFlow<List<User>> get() = _users

    init {
        getUser()
    }


    private fun getUser(){
        viewModelScope.launch{
            try {
                _users.value = userUseCase()
            }catch (e: Exception){

            }
        }
    }











}