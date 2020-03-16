package tech.arnav.intercomgeodist.domain

import tech.arnav.intercomgeodist.data.Customer

/**
 * A [Comparator] that can compare between [Customer] objects
 */
interface CustomerComparator : Comparator<Customer> {

    /**
     * A comparator to compare between two customers based on any
     * one comparable property of [Customer]
     *
     * @param prop a lambda to denote which property to compare
     * @param desc if the sorting is to descending (default: false)
     */
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

        /**
         * Factory method to create a [CustomerPropertyComparator]
         */
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