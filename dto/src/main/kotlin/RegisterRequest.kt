@file:Suppress("Unused")

package com.apsl.glideapp.common.dto

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    val username: String,
    val password: String
)
