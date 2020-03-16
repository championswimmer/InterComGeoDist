package tech.arnav.intercomgeodist.domain

import tech.arnav.intercomgeodist.data.Customer
import tech.arnav.intercomgeodist.geo.GeoPoint
import tech.arnav.intercomgeodist.geo.distanceTo


interface CustomerFilter: (Customer) -> Boolean {

    private class CustomerDistanceFilter constructor(
        val from: GeoPoint,
        val radius: Double
    ) : CustomerFilter {

        override fun invoke(customer: Customer) =
            from.distanceTo(customer.geoPoint) <= radius

    }

    object Factory {

        @JvmStatic
        fun distanceFilter(from: GeoPoint, radius: Double): CustomerFilter {
            return CustomerDistanceFilter(from, radius)
        }
    }
}