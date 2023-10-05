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

/**
 * Returns a compressed list containing [n] elements.
 *
 * @param n size of compressed list
 * @throws IllegalArgumentException if [n] is negative.
 */
fun <T> List<T>.compress(n: Int): List<T> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return this.dropEvery(n = ((this.size.toFloat() / n)).roundToInt())
}
