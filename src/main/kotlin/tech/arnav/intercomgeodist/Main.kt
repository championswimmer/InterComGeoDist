@file:JvmName("Main")

package tech.arnav.intercomgeodist

import tech.arnav.intercomgeodist.data.DataSource
import tech.arnav.intercomgeodist.domain.CustomerComparator
import tech.arnav.intercomgeodist.domain.CustomerFilter
import tech.arnav.intercomgeodist.geo.GeoPoint

fun main() {
    val dublin = GeoPoint(53.339428, -6.257664)
    val nearDublin = CustomerFilter.Factory.distanceFilter(dublin, 100.0)
    val userIdComparator = CustomerComparator.Factory.sortByProperty({ it.userID })

    println(" Users to invite ")
    println("=================")
    println("id \t | name")
    println("-----------------")

    DataSource().getCustomers()
        .filter(nearDublin)
        .sortedWith(userIdComparator)
        .forEach {
            println(
                "${it.userID} \t | ${it.name}"
            )
        }
}