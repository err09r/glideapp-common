@file:Suppress("Unused")

package com.apsl.glideapp.common.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val username: String,
    val password: String
)
