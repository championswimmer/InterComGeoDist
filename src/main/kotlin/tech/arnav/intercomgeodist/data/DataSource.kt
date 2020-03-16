package tech.arnav.intercomgeodist.data

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.io.InputStreamReader

class DataSource {
    companion object {
        const val CUSTOMERS_DATA_FILE_NAME = "customers.txt"
    }

    private fun getDataStream(resourceFile: String): Sequence<String> {
        val url = this::class.java.classLoader.getResource(resourceFile)
        val fistream = url?.openStream() ?: throw IllegalArgumentException("No customer data found")
        val isr = InputStreamReader(fistream)
        return isr.buffered().lineSequence()
    }

    fun getCustomers(): Sequence<Customer> {
        val json = Json(JsonConfiguration.Stable)
        val customers = getDataStream(CUSTOMERS_DATA_FILE_NAME).map {
            json.parse(Customer.serializer(), it)
        }
        return customers
    }

}