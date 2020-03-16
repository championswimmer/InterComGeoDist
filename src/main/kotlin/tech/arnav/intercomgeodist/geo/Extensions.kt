package tech.arnav.intercomgeodist.geo

typealias Degree = Double

/**
 * Convert angle in degrees to angle in radians
 */
fun Degree.toRadians(): Double {
    return (this * Math.PI) / 180
}

/**
 * find distance of this [GeoPoint] to another
 * @param another
 */
fun GeoPoint.distanceTo(another: GeoPoint): Double {
    return GeoDistanceUtils.getDistance(this, another)
//    might need to use the vincenty formula on 32-bit machines
//    for better accuracy
//    return GeoDistanceUtils.getDistanceVincenty(this, another)
}
