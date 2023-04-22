package com.apsl.glideapp.common.dto

import kotlinx.serialization.Serializable

@Serializable
sealed interface RideActionResponse {
    @Serializable
    data class Started(val rideId: String) : RideActionResponse

    @Serializable
    object Paused : RideActionResponse

    @Serializable
    object Finished : RideActionResponse
}
