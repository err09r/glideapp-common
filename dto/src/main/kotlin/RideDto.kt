@file:Suppress("Unused")

package com.apsl.glideapp.common.dto

import com.apsl.glideapp.common.models.Route
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class RideDto(
    val id: String,
    val key: Int?,
    val startAddress: String?,
    val finishAddress: String?,
    val startDateTime: LocalDateTime,
    val finishDateTime: LocalDateTime,
    val route: Route,
    val averageSpeed: Double
)
