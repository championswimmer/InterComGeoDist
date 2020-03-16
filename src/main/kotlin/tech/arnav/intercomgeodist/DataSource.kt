package tech.arnav.intercomgeodist

class DataSource {

    fun readCustomerData(): String? {
        val url = this::class.java.classLoader.getResource("customers.json")
        return url?.readText()
    }

}