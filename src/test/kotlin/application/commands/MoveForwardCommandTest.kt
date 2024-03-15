package application.commands

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
        val robotMovementService = mockk<RobotMovementService>(relaxed = true)
        val moveForwardCommand = MoveForwardCommand(robot,robotMovementService)

        moveForwardCommand.execute()

        verify { robotMovementService.moveForward(robot) }
    }
}