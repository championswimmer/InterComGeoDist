package tech.arnav.intercomgeodist.domain

import tech.arnav.intercomgeodist.data.Customer
import tech.arnav.intercomgeodist.geo.GeoPoint
import tech.arnav.intercomgeodist.geo.distanceTo

/**
 * interface to mark the predicate used to filter [Customer]s
 * in a stream/sequence/list of [Customer]s
 */
interface CustomerFilter: (Customer) -> Boolean {

    /**
     * An implementation of [CustomerFilter] that filters
     * customers that are at-most a certain distance from a
     * [GeoPoint]
     *
     * @param from the center of the fence
     * @param radius the radius of the fence of the filter
     */
    private class CustomerDistanceFilter constructor(
        val from: GeoPoint,
        val radius: Double
    ) : CustomerFilter {

        override fun invoke(customer: Customer) =
            from.distanceTo(customer.geoPoint) <= radius

    }

    object Factory {

        /**
         * Factory method to generate a [CustomerDistanceFilter]
         */
        @JvmStatic
        fun distanceFilter(from: GeoPoint, radius: Double): CustomerFilter {
            return CustomerDistanceFilter(from, radius)
        }
    }
}