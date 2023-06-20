package com.apsl.glideapp.common.dto

import com.apsl.glideapp.common.models.Coordinates
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
sealed interface RideEventDto {

    @Serializable
    data class Started(val rideId: String, val dateTime: LocalDateTime) : RideEventDto

    @Serializable
    data class RouteUpdated(val currentRoute: List<Coordinates>) : RideEventDto

    @Serializable
    sealed class Error(val message: String?) {

        @Serializable
        object UserInsideNoParkingZone : Error("User is inside no-parking zone")
    }

    @Serializable
    object Finished : RideEventDto
}
