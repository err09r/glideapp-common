package com.apsl.glideapp.common.dto

import kotlinx.serialization.Serializable

@Serializable
data class MapStateDto(
    val ridingZones: List<ZoneDto>,
    val availableVehicles: List<VehicleDto>
)
