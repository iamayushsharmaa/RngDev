package com.example.rng.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rng.data.AuthState
import com.example.rng.data.User
import com.example.rng.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState


    fun isUserLoggedIn(): Boolean {
        return userRepository.getCurrentUser() != null
    }

    fun loginOrRegisterUser(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            val user = userRepository.loginUser(email, password)

            if (user != null) {
                // User exists, proceed with login
                _authState.value = AuthState.Success("Login successful")
            } else {
                // User does not exist, register new user
                try {
                    userRepository.registerUser(User(email = email, password = password))
                    _authState.value = AuthState.Success("User registered successfully")
                } catch (e: Exception) {
                    _authState.value = AuthState.Error("Registration failed: ${e.message}")
                }
            }
        }
    }
}

