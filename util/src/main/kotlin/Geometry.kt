@file:Suppress("Unused", "MemberVisibilityCanBePrivate")

package com.apsl.glideapp.common.util

import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

object Geometry {

    private const val EARTH_RADIUS_METERS = 6_371_000

    /**
     * Checks whether the point is inside the polygon.
     *
     * @param vertices polygon vertices.
     * @param point point for research.
     * @see <a href="https://wrf.ecse.rpi.edu/Research/Short_Notes/pnpoly.html">PNPOLY - Point Inclusion in Polygon Test</a>
     */
    fun isInsidePolygon(
        vararg vertices: Pair<Double, Double>,
        point: Pair<Double, Double>
    ): Boolean {
        val (pointX, pointY) = point
        val numberOfVertices = vertices.size
        var isInside = false
        var i = 0
        var j = numberOfVertices - 1
        while (i < numberOfVertices) {
            val (vertX, vertY) = vertices[i]
            val (nextVertX, nextVertY) = vertices[j]

            if (vertY > pointY != nextVertY > pointY && pointX < (nextVertX - vertX) * (pointY - vertY) / (nextVertY - vertY) + vertX) {
                isInside = !isInside
            }
            j = i++
        }
        return isInside
    }

    /**
     * Calculates the total distance between two latitude-longitude points in meters.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Haversine_formula">Haversine formula</a>
     * @see <a href="https://community.esri.com/t5/coordinate-reference-systems-blog/distance-on-a-sphere-the-haversine-formula/ba-p/902128">Distance on a sphere: The Haversine Formula</a>
     * @return distance in meters.
     */
    fun calculateDistance(from: Pair<Double, Double>, to: Pair<Double, Double>): Double {
        return calculateDistance(from, to)
    }

    /**
     * Calculates the total distance of latitude-longitude polyline in meters.
     *
     * @param polyline latitude-longitude pairs describing a polyline.
     * @see <a href="https://en.wikipedia.org/wiki/Haversine_formula">Haversine formula</a>
     * @see <a href="https://community.esri.com/t5/coordinate-reference-systems-blog/distance-on-a-sphere-the-haversine-formula/ba-p/902128">Distance on a sphere: The Haversine Formula</a>
     * @return distance in meters.
     */
    fun calculateDistance(vararg polyline: Pair<Double, Double>): Double {
        var distance = 0.0

        if (polyline.size < 2) {
            return distance
        }

        for (index in polyline.indices) {
            val (latitude, longitude) = polyline[index]
            val nextIndex = index + 1
            if (nextIndex <= polyline.lastIndex) {
                val (nextLatitude, nextLongitude) = polyline[nextIndex]
                val lat1 = Math.toRadians(latitude)
                val long1 = Math.toRadians(longitude)
                val lat2 = Math.toRadians(nextLatitude)
                val long2 = Math.toRadians(nextLongitude)

                distance += 2 * EARTH_RADIUS_METERS *
                        asin(
                            sqrt(
                                sin((lat2 - lat1) / 2)
                                        * sin((lat2 - lat1) / 2)
                                        + cos(lat1) * cos(lat2)
                                        * sin((long2 - long1) / 2)
                                        * sin((long2 - long1) / 2)
                            )
                        )
            }
        }

        return distance
    }
}
