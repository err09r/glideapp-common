@file:Suppress("Unused")

package com.apsl.glideapp.common.util

import kotlin.math.roundToInt

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
 * The first and last element of list are always added.
 * The remaining elements are selected randomly.
 *
 * @param n size of compressed list.
 * @throws IllegalArgumentException if [n] is not between 0 and original list size.
 */
fun <T> List<T>.compress(n: Int): List<T> {
    require(n >= 0) { "Requested n value: $n is less than zero." }
    if (this.size <= 3) {
        return this
    }
    return when (n) {
        0 -> emptyList()
        1 -> this.take(1)
        2 -> listOf(this.first(), this.last())
        this.size -> this
        else -> {
            val ratio = 1f / (n - 2)
            val list = ArrayList<T>(n)
            list.add(this.first())
            this
                .subList(fromIndex = 1, toIndex = this.lastIndex - 1)
                .chunked(size = ((this.size - 2) * ratio).roundToInt())
                .forEach { list.add(it.random()) }
            list.add(this.last())
            return list
        }
    }
}
