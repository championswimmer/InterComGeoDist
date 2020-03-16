package tech.arnav.intercomgeodist.geo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import tech.arnav.intercomgeodist.geo.GeoDistanceUtils.EARTH_RADIUS_KM

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GeoDistanceTests {

    @Test
    fun testDistanceDelhiMumbai() {
        val p1 = GeoPoint(28.7, 77.1)
        val p2 = GeoPoint(19.1, 72.8)
        assertEquals(1153.0, p1.distanceTo(p2), 1.0)
    }

    @Test
    fun testDistanceSamePoint() {
        val p1 = GeoPoint(28.7, 77.1)
        val p2 = GeoPoint(28.7, 77.1)
        assertEquals(0.0, p1.distanceTo(p2))
    }

    @Test
    fun testDistancePoles() {
        val sp = GeoPoint(-90.0, 0.0)
        val np = GeoPoint(90.0, 0.0)
        assertEquals(Math.PI * EARTH_RADIUS_KM, sp.distanceTo(np))
    }
}