package domain

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.example.domain.MarsRobotMovementService
import org.example.domain.entities.MissionMap
import org.example.domain.entities.Robot
import org.example.domain.values.Orientation
import org.example.domain.values.Position
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MarsRobotMovementService {

    @Test
    fun moveRobotForward_lostAfterMove(){
        val map = mockk<MissionMap>(relaxed = true)
        every { map.isWithinBounds(any()) } returns false
        every { map.scentExistsAt(any(), any()) } returns false

        val service = MarsRobotMovementService(map)
        val robot = Robot(Position(5, 5), Orientation.NORTH)

        service.moveForward(robot)

        val result = robot.isAlive()

        assertFalse(result)
        verify { map.addScent(Position(5,5), Orientation.NORTH) }
    }

    @Test
    fun moveRobotForward_scentExists(){
        val map = mockk<MissionMap>(relaxed = true)
        every { map.isWithinBounds(any()) } returns false
        every { map.scentExistsAt(any(), any()) } returns true

        val service = MarsRobotMovementService(map)
        val robot = Robot(Position(5, 5), Orientation.NORTH)

        service.moveForward(robot)

        val result = robot.isAlive()

        assertTrue(result)
        assertEquals(Position(5,5), robot.position)
    }

    @Test
    fun moveRobotForward_success(){
        val map = mockk<MissionMap>(relaxed = true)
        every { map.isWithinBounds(any()) } returns true
        every { map.scentExistsAt(any(), any()) } returns false

        val service = MarsRobotMovementService(map)
        val robot = Robot(Position(5, 5), Orientation.NORTH)

        service.moveForward(robot)

        val result = robot.isAlive()

        assertTrue(result)
        assertEquals(Position(5,6), robot.position)
    }
}