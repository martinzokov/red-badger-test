package domain.entities

import org.example.domain.entities.Robot
import org.example.domain.values.Orientation
import org.example.domain.values.Position
import org.example.domain.values.RobotStatus
import kotlin.test.Test
import kotlin.test.assertEquals

class RobotTest {
    @Test
    fun moveForward_north(){
        val startingPosition = Position(5, 5)
        val startingOrientation = Orientation.NORTH
        val robot = Robot(startingPosition, startingOrientation)


        assertEquals(Position(5, 6), robot.getNextPosition())
    }

    @Test
    fun moveForward_south(){
        val startingPosition = Position(5, 5)
        val startingOrientation = Orientation.SOUTH
        val robot = Robot(startingPosition, startingOrientation)

        assertEquals(Position(5, 4), robot.getNextPosition())
    }

    @Test
    fun moveForward_east(){
        val startingPosition = Position(5, 5)
        val startingOrientation = Orientation.EAST
        val robot = Robot(startingPosition, startingOrientation)

        assertEquals(Position(6, 5), robot.getNextPosition())
    }

    @Test
    fun moveForward_west(){
        val startingPosition = Position(5, 5)
        val startingOrientation = Orientation.WEST
        val robot = Robot(startingPosition, startingOrientation)


        assertEquals(Position(4, 5), robot.getNextPosition())
    }

    @Test
    fun status_alive(){
        val robot = Robot(Position(5,5), Orientation.NORTH)

        robot.status(RobotStatus.LOST)

        assertEquals(RobotStatus.LOST, robot.status)
    }

    @Test
    fun turnRobotLeft_fromNorth(){
        val robot = Robot(Position(5,5), Orientation.NORTH)

        robot.turnLeft()

        assertEquals(Orientation.WEST, robot.orientation)
    }

    @Test
    fun turnRobotLeft_fromWest(){
        val robot = Robot(Position(5,5), Orientation.WEST)

        robot.turnLeft()

        assertEquals(Orientation.SOUTH, robot.orientation)
    }

    @Test
    fun turnRobotLeft_fromSouth(){
        val robot = Robot(Position(5,5), Orientation.SOUTH)

        robot.turnLeft()

        assertEquals(Orientation.EAST, robot.orientation)
    }

    @Test
    fun turnRobotLeft_fromEast(){
        val robot = Robot(Position(5,5), Orientation.EAST)

        robot.turnLeft()

        assertEquals(Orientation.NORTH, robot.orientation)
    }

    @Test
    fun turnRobotRight_fromNorth(){
        val robot = Robot(Position(5,5), Orientation.NORTH)

        robot.turnRight()

        assertEquals(Orientation.EAST, robot.orientation)
    }

    @Test
    fun turnRobotRight_fromWest(){
        val robot = Robot(Position(5,5), Orientation.WEST)

        robot.turnRight()

        assertEquals(Orientation.NORTH, robot.orientation)
    }

    @Test
    fun turnRobotRight_fromSouth(){
        val robot = Robot(Position(5,5), Orientation.SOUTH)

        robot.turnRight()

        assertEquals(Orientation.WEST, robot.orientation)
    }

    @Test
    fun turnRobotRight_fromEast(){
        val robot = Robot(Position(5,5), Orientation.EAST)

        robot.turnRight()

        assertEquals(Orientation.SOUTH, robot.orientation)
    }
}