@file:Suppress("Unused")

package com.apsl.glideapp.common.util

import kotlin.math.roundToInt

fun String.capitalized(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}

fun Double.format(digits: Int): String = "%.${digits}f".format(this)

/**
 * Returns a list containing all elements except every [n]-th element.
 *
 * @throws IllegalArgumentException if [n] is negative.
 */
fun <T> Iterable<T>.dropEvery(n: Int): List<T> {
    require(n >= 0) { "Requested n value: $n is less than zero." }
    if (n == 0) return toList()
    val list = ArrayList<T>()
    for ((i, item) in this.withIndex()) {
        if ((i + 1) % n != 0) {
            list.add(item)
        }
    }
    return list
}

// Create docs
fun <T> List<T>.compress(n: Int): List<T> {
    require(n in 0..this.size) { "Requested n value: $n is not between 0 and 1." }
    if (this.size <= 3) {
        return this
    }
    val rate = 1f / (n - 2)
    val list = ArrayList<T>()
    list.add(this[0])

    this
        .subList(fromIndex = 1, toIndex = this.lastIndex - 1)
        .chunked(size = ((this.size - 2) * rate).roundToInt())
        .forEach { list.add(it.random()) }

    list.add(this[this.lastIndex])
    return list
}
