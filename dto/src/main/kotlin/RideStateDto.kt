package com.apsl.glideapp.common.dto

import kotlinx.serialization.Serializable

@Serializable
sealed interface RideStateDto {
    @Serializable
    data class Started(val rideId: String) : RideStateDto

    @Serializable
    object Paused : RideStateDto

    @Serializable
    object Finished : RideStateDto
}
