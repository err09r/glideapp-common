package com.apsl.glideapp.common.models

import kotlinx.serialization.Serializable

@Serializable
data class CoordinatesBounds(
    val southwest: Coordinates,
    val northeast: Coordinates
)
