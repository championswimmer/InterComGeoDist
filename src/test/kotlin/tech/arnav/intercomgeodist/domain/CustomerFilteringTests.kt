package tech.arnav.intercomgeodist.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import tech.arnav.intercomgeodist.data.Customer
import tech.arnav.intercomgeodist.geo.GeoPoint

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerFilteringTests {

    @Test
    fun filterWithinRadiusWorks() {
        val customers = listOf(
            Customer("27.77", 1, "John", "77.66"),
            Customer("27.78", 2, "Jane", "77.65"),
            Customer("10.5", 2, "Nancy", "55.66")
        )
        val radiusFilter = CustomerFilter.Factory.distanceFilter(
            GeoPoint(27.75, 77.55), 100.0
        )
        val filteredCustomers = customers.filter(radiusFilter)
        assertEquals(2, filteredCustomers.size)
        assertEquals(1, filteredCustomers[0].userID)
        assertEquals(2, filteredCustomers[1].userID)
    }
}