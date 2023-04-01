package com.apsl.glideapp.common.dto

import com.apsl.glideapp.common.util.UUID
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: UUID,
    val username: String,
    val firstName: String,
    val lastName: String
)

