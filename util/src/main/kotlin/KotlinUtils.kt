@file:Suppress("Unused", "UnusedReceiverParameter")

package com.apsl.glideapp.common.util

fun String.capitalized(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}

fun Double.format(digits: Int): String = "%.${digits.coerceAtLeast(0)}f".format(this)
