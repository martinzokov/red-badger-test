package application.commands

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.example.application.commands.MoveForwardCommand
import org.example.domain.RobotMovementService
import org.example.domain.entities.Robot

import org.junit.jupiter.api.Test

class MoveForwardCommandTest {
    @Test
    fun executeMoveForward(){
        val robot = mockk<Robot>()
        every { robot.isAlive() } returns true
        val robotMovementService = mockk<RobotMovementService>(relaxed = true)
        val moveForwardCommand = MoveForwardCommand(robot,robotMovementService)

        moveForwardCommand.execute()

        verify { robotMovementService.moveForward(robot) }
    }

    @Test
    fun executeMoveForward_robotAlreadyLost(){
        val robot = mockk<Robot>()
        every { robot.isAlive() } returns false
        val robotMovementService = mockk<RobotMovementService>(relaxed = true)
        val moveForwardCommand = MoveForwardCommand(robot,robotMovementService)

        moveForwardCommand.execute()

        verify(exactly = 0) { robotMovementService.moveForward(robot) }
    }
}