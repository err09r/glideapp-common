@file:Suppress("Unused", "MemberVisibilityCanBePrivate")

package com.apsl.glideapp.common.models

import java.util.Objects
import kotlinx.serialization.Serializable

@Serializable
class CoordinatesBounds {

    val southwest: Coordinates
    val northeast: Coordinates

    constructor(southwest: Coordinates, northeast: Coordinates) {
        val swLat = southwest.latitude
        val neLat = northeast.latitude

        require(neLat >= swLat) {
            "Southern latitude exceeds northern latitude ($swLat > $neLat)"
        }

        this.southwest = southwest
        this.northeast = northeast
    }

    operator fun component1(): Coordinates = this.southwest
    operator fun component2(): Coordinates = this.northeast

    fun asPair(): Pair<Coordinates, Coordinates> = component1() to component2()

    val center: Coordinates
        get() {
            val centerLatitude = (southwest.latitude + northeast.latitude) / 2.0
            val centerLongitude = (southwest.longitude + northeast.longitude) / 2.0
            return Coordinates(latitude = centerLatitude, longitude = centerLongitude)
        }

    fun contains(point: Coordinates): Boolean {
        return point.latitude in this.southwest.latitude..this.northeast.latitude &&
                point.longitude in this.southwest.longitude..this.northeast.longitude
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
    val topmostLatitude = this.maxOf { it.latitude }
    val bottommostLatitude = this.minOf { it.latitude }
    val leftmostLongitude = this.minOf { it.longitude }
    val rightmostLongitude = this.maxOf { it.longitude }

    val southwest = Coordinates(latitude = bottommostLatitude, longitude = leftmostLongitude)
    val northeast = Coordinates(latitude = topmostLatitude, longitude = rightmostLongitude)

    return CoordinatesBounds(southwest = southwest, northeast = northeast)
}
