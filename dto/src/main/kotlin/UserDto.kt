package com.apsl.glideapp.common.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: String,
    val username: String,
    val firstName: String,
    val lastName: String
)

