package com.example.valorantapplication.data

import com.example.valorantapplication.enums.Gender
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val username: String,
    val password: String,
    val email: String,
    val gender: Gender,
)