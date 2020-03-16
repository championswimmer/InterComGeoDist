package tech.arnav.intercomgeodist.data

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DataSourceTests {
    lateinit var dataSource: DataSource

    @BeforeAll
    fun setup() {
        dataSource = DataSource()
    }

    @Test
    fun canReadCustomersData() {
        val customers = dataSource.getCustomers().toList()
        assertTrue(customers.isNotEmpty())
    }
}