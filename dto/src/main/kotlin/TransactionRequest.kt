package com.apsl.glideapp.common.dto

import com.apsl.glideapp.common.models.TransactionType
import kotlinx.serialization.Serializable

@Serializable
data class TransactionRequest(
    val type: TransactionType,
    val amount: Double?
)
