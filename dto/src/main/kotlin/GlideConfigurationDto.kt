package com.apsl.glideapp.common.dto

import kotlinx.serialization.Serializable

@Serializable
data class GlideConfigurationDto(
    val countryCode: String,
    val unlockingFee: Double,
    val farePerMinute: Double
)
