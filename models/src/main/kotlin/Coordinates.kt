@file:Suppress("Unused", "MemberVisibilityCanBePrivate")

package com.apsl.glideapp.common.models

import kotlin.math.max
import kotlin.math.min
import kotlinx.serialization.Serializable

@Serializable
class Coordinates {

    val latitude: Double
    val longitude: Double

    constructor(latitude: Double, longitude: Double) {
        this.latitude = max(-90.0, min(90.0, latitude))
        this.longitude = if (!(longitude < -180.0) && longitude < 180.0) {
            longitude
        } else {
            ((longitude + -180.0) % 360.0 + 360.0) % 360.0 + -180.0
        }
    }

    operator fun component1(): Double = latitude
    operator fun component2(): Double = longitude

    fun asPair(): Pair<Double, Double> = component1() to component2()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is Coordinates) {
            return false
        }
        return latitude.toBits() == other.latitude.toBits() && longitude.toBits() == other.longitude.toBits()
    }

    override fun hashCode(): Int {
        val latBits = latitude.toBits()
        val lonBits = longitude.toBits()
        return ((latBits xor latBits ushr 32).toInt() + 31) * 31 + (lonBits xor lonBits ushr 32).toInt()
    }

    override fun toString(): String {
        return "Coordinates(latitude=$latitude, longitude=$longitude)"
    }

    fun copy(latitude: Double = this.latitude, longitude: Double = this.longitude): Coordinates {
        return Coordinates(latitude = latitude, longitude = longitude)
    }
}

fun List<Coordinates>.asPairs(): Array<Pair<Double, Double>> = this.map(Coordinates::asPair).toTypedArray()
