@file:Suppress("Unused", "MemberVisibilityCanBePrivate")

package com.apsl.glideapp.common.models

import com.apsl.glideapp.common.util.Geometry
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class Route(val points: List<Coordinates>) {

    val center: Coordinates
        get() = points.toCoordinatesBounds().center

    val distance: Double
        get() = Geometry.calculateDistance(polyline = points.asPairs())
}
