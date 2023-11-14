package com.apsl.glideapp.common.dto

import kotlinx.serialization.Serializable

@Serializable
data class MapContentDto(val availableVehicles: List<VehicleDto>)
