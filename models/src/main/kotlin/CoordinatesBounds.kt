@file:Suppress("Unused", "MemberVisibilityCanBePrivate")

package com.apsl.glideapp.common.models

import java.util.Objects
import kotlinx.serialization.Serializable

@Serializable
class CoordinatesBounds {

    val southwest: Coordinates
    val northeast: Coordinates

    constructor(southwest: Coordinates, northeast: Coordinates) {
        val neLat = northeast.latitude
        val swLat = southwest.latitude

        require(neLat >= swLat) {
            "Southern latitude exceeds northern latitude ($swLat > $neLat)"
        }

        this.southwest = southwest
        this.northeast = northeast
    }

    operator fun component1(): Coordinates = this.southwest
    operator fun component2(): Coordinates = this.northeast

    val center: Coordinates
        get() {
            val swLat = this.southwest.latitude
            val swLon = this.southwest.longitude
            val neLat = this.northeast.latitude
            val neLon = this.northeast.longitude

            val centerLatitude = (swLat + neLat) / 2.0
            val centerLongitude = if (swLon <= neLon) {
                (neLon + swLon) / 2.0
            } else {
                (neLon + 360.0 + swLon) / 2.0
            }

            return Coordinates(latitude = centerLatitude, longitude = centerLongitude)
        }

    fun contains(point: Coordinates): Boolean {
        val pointLat = point.latitude
        return this.southwest.latitude <= pointLat
                && pointLat <= this.northeast.latitude
                && this.isBetween(point.longitude)
    }

    private fun isBetween(longitude: Double): Boolean {
        val swLong = this.southwest.longitude
        val neLong = this.northeast.longitude
        return if (swLong <= neLong) {
            longitude in swLong..neLong
        } else {
            swLong <= longitude || longitude <= neLong
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is CoordinatesBounds) {
            return false
        }
        return this.southwest == other.southwest && this.northeast == other.northeast
    }

    override fun hashCode(): Int {
        return Objects.hashCode(arrayOf(this.southwest, this.northeast))
    }

    override fun toString(): String {
        return "CoordinatesBounds(southwest=$southwest, northeast=$northeast, center=$center)"
    }

    fun copy(southwest: Coordinates = this.southwest, northeast: Coordinates = this.northeast): CoordinatesBounds {
        return CoordinatesBounds(southwest = southwest, northeast = northeast)
    }
}

val CoordinatesBounds.Companion.Empty
    get() = CoordinatesBounds(southwest = Coordinates(0.0, 0.0), northeast = Coordinates(0.0, 0.0))

fun List<Coordinates>.toCoordinatesBounds(): CoordinatesBounds {
    val topmostLatitude = this.minOf { it.latitude }
    val bottommostLatitude = this.maxOf { it.latitude }
    val leftmostLongitude = this.minOf { it.longitude }
    val rightmostLongitude = this.maxOf { it.longitude }

    val southwest = Coordinates(latitude = bottommostLatitude, longitude = leftmostLongitude)
    val northeast = Coordinates(latitude = topmostLatitude, longitude = rightmostLongitude)

    return CoordinatesBounds(southwest = southwest, northeast = northeast)
}
