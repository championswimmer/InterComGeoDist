package tech.arnav.intercomgeodist.geo

typealias Degree = Double

fun Degree.toRadians(): Double {
    return (this * Math.PI) / 180
}

fun GeoPoint.distanceTo(another: GeoPoint): Double {
    return GeoDistanceUtils.getDistance(this, another)
//    might need to use the vincenty formula on 32-bit machines
//    for better accuracy
//    return GeoDistanceUtils.getDistanceVincenty(this, another)
}
