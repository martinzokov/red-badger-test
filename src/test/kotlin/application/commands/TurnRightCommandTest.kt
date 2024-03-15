package application.commands

import io.mockk.mockk
import io.mockk.verify
import org.example.application.commands.TurnRightCommand
import org.example.domain.entities.Robot
import org.junit.jupiter.api.Test

class TurnRightCommandTest {
    @Test
    fun executeTurnRight(){
        val robot = mockk<Robot>(relaxed = true)
        val moveForwardCommand = TurnRightCommand(robot)

        moveForwardCommand.execute()

        verify { robot.turnRight() }
    }
}