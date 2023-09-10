package com.apsl.glideapp.common.dto

import com.apsl.glideapp.common.models.Coordinates
import com.apsl.glideapp.common.models.ZoneType
import kotlinx.serialization.Serializable

@Serializable
data class ZoneDto(
    val id: String,
    val code: Int,
    val title: String,
    val type: ZoneType,
    val coordinates: List<Coordinates>
)
