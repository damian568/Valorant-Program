package com.example.valorantapplication.data

import com.example.valorantapplication.enums.QuizOn
import kotlinx.serialization.Serializable

@Serializable
data class QuizUsername(
    val username: String,
    val category: QuizOn
)