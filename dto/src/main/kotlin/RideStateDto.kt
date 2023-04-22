package com.apsl.glideapp.common.dto

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
sealed interface RideStateDto {
    @Serializable
    data class Started(val rideId: String, val dateTime: LocalDateTime) : RideStateDto

    @Serializable
    object Paused : RideStateDto

    @Serializable
    object Finished : RideStateDto
}
