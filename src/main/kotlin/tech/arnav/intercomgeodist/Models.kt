package tech.arnav.intercomgeodist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

typealias Customers = ArrayList<Customer>

@Serializable
data class Artist(
    val name: String,
    val founded: Long,
    val members: List<String>
)

@Serializable
data class Customer(
    val latitude: String,

    @SerialName("user_id")
    val userID: Long,

    val name: String,
    val longitude: String
)

@Serializable
data class Track(
    val name: String,
    val duration: Long
)
