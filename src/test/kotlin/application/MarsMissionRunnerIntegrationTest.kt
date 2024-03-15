package application

import org.example.application.MarsMissionRunner
import org.example.domain.values.Orientation
import org.example.domain.values.RobotStatus
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MarsMissionRunnerIntegrationTest {
    @Test
    fun deploySingleRobot(){
        val runner = MarsMissionRunner(5, 3)

        runner.deployRobot(1, 1, Orientation.EAST)
        val report = runner.receiveRobotInstructions("RFRFRFRF")

        assertEquals(1, report.position.xPosition)
        assertEquals(1, report.position.yPosition)
        assertEquals(Orientation.EAST, report.orientation)
        assertEquals(report.robotStatus, RobotStatus.ALIVE)
    }

    @Test
    fun deployMultipleRobotsSequentially(){
        val runner = MarsMissionRunner(5, 3)

        runner.deployRobot(1, 1, Orientation.EAST)
        val report = runner.receiveRobotInstructions("RFRFRFRF")

        assertEquals(1, report.position.xPosition)
        assertEquals(1, report.position.yPosition)
        assertEquals(Orientation.EAST, report.orientation)
        assertEquals(report.robotStatus, RobotStatus.ALIVE)

        runner.deployRobot(3, 2, Orientation.NORTH)
        val report2 = runner.receiveRobotInstructions("FRRFLLFFRRFLL")

        assertEquals(3, report2.position.xPosition)
        assertEquals(3, report2.position.yPosition)
        assertEquals(Orientation.NORTH, report2.orientation)
        assertEquals(report2.robotStatus, RobotStatus.LOST)

        runner.deployRobot(0, 3, Orientation.WEST)
        val report3 = runner.receiveRobotInstructions("LLFFFLFLFL")

        assertEquals(2, report3.position.xPosition)
        assertEquals(3, report3.position.yPosition)
        assertEquals(Orientation.SOUTH, report3.orientation)
        assertEquals(report3.robotStatus, RobotStatus.ALIVE)
    }

    @Test
    fun deployMultipleRobots_avoidScent(){
        val runner = MarsMissionRunner(1, 1)

        runner.deployRobot(1, 1, Orientation.EAST)
        val report = runner.receiveRobotInstructions("F")

        assertEquals(1, report.position.xPosition)
        assertEquals(1, report.position.yPosition)
        assertEquals(Orientation.EAST, report.orientation)
        assertEquals(report.robotStatus, RobotStatus.LOST)

        runner.deployRobot(1, 1, Orientation.EAST)
        val report2 = runner.receiveRobotInstructions("F")

        assertEquals(1, report2.position.xPosition)
        assertEquals(1, report2.position.yPosition)
        assertEquals(Orientation.EAST, report2.orientation)
        assertEquals(report2.robotStatus, RobotStatus.ALIVE)
    }
}