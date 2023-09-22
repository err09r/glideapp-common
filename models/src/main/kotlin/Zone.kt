package com.apsl.glideapp.common.models

import kotlinx.serialization.Serializable

@Serializable
data class Zone(
    val id: String,
    val code: Int,
    val title: String,
    val type: ZoneType,
    val coordinates: List<Coordinates>
)
