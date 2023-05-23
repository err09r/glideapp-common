package com.apsl.glideapp.common.dto

import com.apsl.glideapp.common.models.Coordinates
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class RideDto(
    val id: String,
    val startAddress: String?,
    val finishAddress: String?,
    val startDateTime: LocalDateTime,
    val finishDateTime: LocalDateTime,
    val route: List<Coordinates>,
    val distance: Double,
    val averageSpeed: Double
)
