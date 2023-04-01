package com.apsl.glideapp.common.dto

import com.apsl.glideapp.common.models.Coordinates
import kotlinx.serialization.Serializable

@Serializable
data class ZoneDto(
    val code: Int,
    val title: String,
    val coordinates: List<Coordinates>
)
