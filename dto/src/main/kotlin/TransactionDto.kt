package com.apsl.glideapp.common.dto

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class TransactionDto(
    val id: String,
    val amount: Double,
    val dateTime: LocalDateTime
)
