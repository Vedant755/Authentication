package com.example.authentication.model

data class UserResponse(
    val token: String,
    val user: User
)