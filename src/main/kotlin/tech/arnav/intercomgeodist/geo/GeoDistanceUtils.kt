package tech.arnav.intercomgeodist.geo

import kotlin.math.acos
import kotlin.math.atan
import kotlin.math.cos
import kotlin.math.sin

object GeoDistanceUtils {

    const val EARTH_RADIUS_KM = 6371

    /**
     * get distance between two points using spherical law
     * of cosines
     * @param p1 first point
     * @param p2 second point
     * @return great-circle distance between points in KMs
     */
    @JvmStatic
    fun getDistance(p1: GeoPoint, p2: GeoPoint): Double {
        val lambda1 = p1.long.toRadians()
        val phi1 = p1.lat.toRadians()

        val lambda2 = p2.long.toRadians()
        val phi2 = p2.lat.toRadians()

        val dLambda = lambda2 - lambda1
        val dPhi = phi2 - phi1

        val centralAngle =
            acos(
                (sin(phi1) * sin(phi2)) +
                        (cos(phi1) * cos(phi2) * cos(dLambda))
            )
        val arcLength = EARTH_RADIUS_KM * centralAngle

        return arcLength

    }

    /**
     * get distance between two points on the earth's surface
     * using the Vincenty Formula
     * [read more](https://en.wikipedia.org/wiki/Vincenty%27s_formulae)
     *
     * @param p1 first point
     * @param p2 second point
     * @return great-circle distance between points in KMs
     */
    @JvmStatic
    fun getDistanceVincenty(p1: GeoPoint, p2: GeoPoint): Double {
        val lambda1 = p1.long.toRadians()
        val phi1 = p1.lat.toRadians()

        val lambda2 = p2.long.toRadians()
        val phi2 = p2.lat.toRadians()

        val dLambda = lambda2 - lambda1
        val dPhi = phi2 - phi1

        val num = Math.sqrt(
            Math.pow((cos(phi2) * sin(dLambda)), 2.0)
                    + Math.pow(((cos(phi1) * sin(phi2)) - (sin(phi1) * cos(phi2) * cos(dLambda))), 2.0)
        )
        val denom =
            (sin(phi1) * sin(phi2)) + (cos(phi1) * cos(phi2) * cos(dLambda))

        val centralAngle =
            atan(num / denom)


        val arcLength = EARTH_RADIUS_KM * centralAngle

        return arcLength

    }
}