package tech.arnav.intercomgeodist.data

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.io.InputStreamReader

class DataSource {
    companion object {
        const val CUSTOMERS_DATA_FILE_NAME = "customers.txt"
    }

    /**
     * read a file from resource directory as a stream and return
     * a [Sequence] of strings - each is a line of the file
     *
     * you can perform any running operation on the stream of lines
     * for any arbitrarily large file, **unless** you turn the sequence
     * into a list like [Sequence.toList] in which case the entire contents
     * of the file will be loaded into memory.
     *
     * @param resourceFile name of file in resource folder
     */
    private fun getDataStream(resourceFile: String): Sequence<String> {
        val url = this::class.java.classLoader.getResource(resourceFile)
        val fistream = url?.openStream() ?: throw IllegalArgumentException("No customer data found")
        val isr = InputStreamReader(fistream)
        return isr.buffered().lineSequence()
    }

    /**
     * gets a sequence of [Customer] objects read from the data source
     *
     * ideally you can perform streaming operations on the sequence
     * without loading it entirely into memory.
     */
    fun getCustomers(): Sequence<Customer> {
        val json = Json(JsonConfiguration.Stable)
        val customers = getDataStream(CUSTOMERS_DATA_FILE_NAME).map {
            json.parse(Customer.serializer(), it)
        }
        return customers
    }

}