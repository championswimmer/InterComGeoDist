package tech.arnav.intercomgeodist.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import tech.arnav.intercomgeodist.data.Customer

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerComparatorTests {

    @Test
    fun compareByIdWorks() {
        val customers = listOf(
            Customer("27.77", 1, "John", "77.66"),
            Customer("27.78", 2, "Jane", "77.65"),
            Customer("10.5", 3, "Nancy", "55.66")
        )
        val idDescComp = CustomerComparator.Factory.sortByProperty({ it.userID }, true)
        val sortedCustomers = customers.sortedWith(idDescComp)
        Assertions.assertEquals(3, sortedCustomers[0].userID)
    }

    @Test
    fun compareByLatitudeWorks() {
        val customers = listOf(
            Customer("27.77", 1, "John", "77.66"),
            Customer("27.78", 2, "Jane", "77.65"),
            Customer("10.5", 3, "Nancy", "55.66")
        )
        val idDescComp = CustomerComparator.Factory.sortByProperty({ it.latitude })
        val sortedCustomers = customers.sortedWith(idDescComp)
        Assertions.assertEquals("10.5", sortedCustomers[0].latitude)
    }

}