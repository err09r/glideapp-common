package com.apsl.glideapp.core.domain.home

import com.apsl.glideapp.common.models.Coordinates
import com.apsl.glideapp.common.models.VehicleStatus
import com.apsl.glideapp.common.models.VehicleType
import kotlinx.serialization.Serializable

@Serializable
data class Vehicle(
    val id: String,
    val code: Int,
    val batteryCharge: Int,
    val type: VehicleType,
    val status: VehicleStatus,
    val coordinates: Coordinates
)
