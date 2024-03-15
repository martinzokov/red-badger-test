package application.commands

import io.mockk.mockk
import io.mockk.verify
import org.example.application.commands.RobotCommand
import org.example.application.commands.RobotCommandInvoker
import org.junit.jupiter.api.Test

class RobotCommandInvokerTest {

    @Test
    fun invokeCommand(){
        val command = mockk<RobotCommand>(relaxed = true)
        val robotCommandInvoker = RobotCommandInvoker()

        robotCommandInvoker.executeCommand(command)

        verify { command.execute() }
    }
}