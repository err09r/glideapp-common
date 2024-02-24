@file:Suppress("Unused", "SameParameterValue")

package com.apsl.glideapp.common.dto

import com.apsl.glideapp.common.models.Route
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
sealed interface RideEventDto {

    @Serializable
    data class Started(val rideId: String, val vehicle: VehicleDto, val dateTime: LocalDateTime) : RideEventDto

    @Serializable
    data class Restored(val rideId: String, val vehicle: VehicleDto, val startDateTime: LocalDateTime) : RideEventDto

    @Serializable
    data class RouteUpdated(val currentRoute: Route) : RideEventDto

    @Serializable
    sealed class Error(val message: String?) : RideEventDto {

        @Serializable
        data object UserInsideNoParkingZone : Error("User is inside no-parking zone")

        @Serializable
        data object UserTooFarFromVehicle : Error("User is too far from vehicle")

        @Serializable
        data object NotEnoughFunds : Error("User does not have enough funds to start a ride")
    }

    @Serializable
    data class Finished(val distance: Double, val averageSpeed: Double) : RideEventDto

    @Serializable
    data class SessionCancelled(val message: String? = null) : RideEventDto
}
