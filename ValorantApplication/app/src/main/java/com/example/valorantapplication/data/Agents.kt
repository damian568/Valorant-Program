package com.example.valorantapplication.data

import kotlinx.serialization.Serializable

@Serializable
data class Agents(
    val imageResourceAgent: Int,
    val nameAgent: String,
    val roleAgent: String
)
