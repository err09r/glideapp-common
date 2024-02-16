@file:Suppress("Unused")

package com.apsl.glideapp.common.dto

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val code: Int?,
    val description: String
)
