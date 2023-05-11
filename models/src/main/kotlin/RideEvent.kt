package com.apsl.glideapp.common.models

import kotlinx.serialization.Serializable

@Serializable
sealed interface RideEvent {

    @Serializable
    object Started : RideEvent

    @Serializable
    data class RouteUpdated(private val currentRoute: List<Coordinates>) : RideEvent

    @Serializable
    object Finished : RideEvent
}
