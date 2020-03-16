package tech.arnav.intercomgeodist.domain

import tech.arnav.intercomgeodist.data.Customer

interface CustomerComparator : Comparator<Customer> {

    private class CustomerPropertyComparator(
        val prop: (c: Customer) -> Comparable<Any>,
        val desc: Boolean
    ) : CustomerComparator {
        override fun compare(p0: Customer, p1: Customer) = if (!desc) {
            prop(p0).compareTo(prop(p1))
        } else {
            prop(p1).compareTo(prop(p0))
        }
    }

    object Factory {
        @Suppress("UNCHECKED_CAST")
        @JvmStatic
        fun sortByProperty(
            prop: (c: Customer) -> Comparable<*>,
            desc: Boolean = false
        ): CustomerComparator {
            return CustomerPropertyComparator(prop as (Customer) -> Comparable<Any>, desc)
        }
    }

}