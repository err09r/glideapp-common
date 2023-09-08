package com.apsl.glideapp.common.dto

import kotlinx.serialization.Serializable

@Serializable
data class AppConfigDto(
    val unlockDistance: Double,
    val ridingZones: List<ZoneDto>,
    val noParkingZones: List<ZoneDto>
)
