package tech.arnav.intercomgeodist.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import tech.arnav.intercomgeodist.geo.GeoPoint

@Serializable
data class Customer(
    val latitude: String,

    @SerialName("user_id")
    val userID: Long,

    val name: String,
    val longitude: String
) {
    @Transient
    val geoPoint = GeoPoint(latitude.toDouble(), longitude.toDouble())
}