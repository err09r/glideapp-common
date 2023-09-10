package com.apsl.glideapp.common.dto

import com.apsl.glideapp.common.models.Coordinates
import com.apsl.glideapp.common.models.VehicleStatus
import com.apsl.glideapp.common.models.VehicleType
import kotlinx.serialization.Serializable

@Serializable
data class VehicleDto(
    val id: String,
    val code: Int,
    val batteryCharge: Int,
    val type: VehicleType,
    val status: VehicleStatus,
    val coordinates: Coordinates
)
