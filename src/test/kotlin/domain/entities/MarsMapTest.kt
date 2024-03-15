package domain.entities

import org.example.domain.entities.MarsMap
import org.example.domain.values.Orientation
import org.example.domain.values.Position
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.Test
import kotlin.test.assertFalse

class MarsMapTest {

    @Test
    fun testAddScent() {
        val marsMap = MarsMap(Position(10, 10))

        marsMap.addScent(Position(0, 0), Orientation.SOUTH)
        assertTrue(marsMap.scentExistsAt(Position(0, 0), Orientation.SOUTH))
    }


    @Test
    fun testIsWithinBounds() {
        val marsMap = MarsMap(Position(5, 5))

        assertTrue(marsMap.isWithinBounds(Position(0, 0)))
        assertTrue(marsMap.isWithinBounds(Position(5, 5)))
        assertFalse(marsMap.isWithinBounds(Position(6, 5)))
        assertFalse(marsMap.isWithinBounds(Position(5, 6)))
    }
}