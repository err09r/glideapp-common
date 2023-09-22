package com.apsl.glideapp.common.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val username: String,
    val firstName: String,
    val lastName: String,
    val totalDistance: Double,
    val totalRides: Int,
    val balance: Double
)
