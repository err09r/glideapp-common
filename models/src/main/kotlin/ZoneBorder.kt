@file:Suppress("Unused", "MemberVisibilityCanBePrivate")

package com.apsl.glideapp.common.models

import com.apsl.glideapp.common.util.Geometry
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class ZoneBorder(val points: List<Coordinates>) {

    // Consider calculating 'visual' center instead of actual center
    // Source: https://stackoverflow.com/questions/1203135/what-is-the-fastest-way-to-find-the-visual-center-of-an-irregularly-shaped-pol
    val center: Coordinates
        get() = points.toCoordinatesBounds().center

    fun contains(point: Coordinates): Boolean {
        return Geometry.isInsidePolygon(point = point.asPair(), vertices = points.asPairs())
    }
}
