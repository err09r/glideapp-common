package com.apsl.glideapp.common.models

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
sealed interface RideAction {

    @Serializable
    data object RequestCurrentState : RideAction

    @Serializable
    data class Start(
        val vehicleId: String,
        val coordinates: Coordinates,
        val address: String?,
        val dateTime: LocalDateTime
    ) : RideAction

    @Serializable
    data class UpdateRoute(val rideId: String, val coordinates: Coordinates) : RideAction

    @Serializable
    data class Finish(
        val rideId: String,
        val coordinates: Coordinates,
        val address: String?,
        val dateTime: LocalDateTime
    ) : RideAction
}
