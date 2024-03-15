package application.commands

import io.mockk.mockk
import io.mockk.verify
import org.example.application.commands.TurnLeftCommand
import org.example.domain.entities.Robot
import org.junit.jupiter.api.Test

class TurnLeftCommandTest {
    @Test
    fun executeTurnLeft(){
        val robot = mockk<Robot>(relaxed = true)
        val moveForwardCommand = TurnLeftCommand(robot)

        moveForwardCommand.execute()

        verify { robot.turnLeft() }
    }
}