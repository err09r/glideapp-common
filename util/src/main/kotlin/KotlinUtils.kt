package com.apsl.glideapp.common.util

fun String.capitalized(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}

fun Double.format(digits: Int): String = "%.${digits}f".format(this)
