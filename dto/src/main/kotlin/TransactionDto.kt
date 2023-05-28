package com.apsl.glideapp.common.dto

import com.apsl.glideapp.common.models.TransactionType
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class TransactionDto(
    val id: String,
    val key: Int?,
    val amount: Double,
    val type: TransactionType,
    val dateTime: LocalDateTime
)
