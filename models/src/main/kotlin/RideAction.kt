package com.apsl.glideapp.common.models

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
sealed interface RideAction {
    @Serializable
    data class Start(val address: String, val vehicleId: String, val dateTime: LocalDateTime) : RideAction

    @Serializable
    data class Pause(val rideId: String) : RideAction

    @Serializable
    data class Finish(
        val rideId: String,
        val vehicleId: String,
        val address: String,
        val dateTime: LocalDateTime
    ) : RideAction
}
