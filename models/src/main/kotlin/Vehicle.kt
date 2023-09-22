package com.apsl.glideapp.common.models

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
