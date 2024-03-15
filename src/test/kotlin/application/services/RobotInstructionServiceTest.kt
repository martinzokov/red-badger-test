package application.services

import io.mockk.clearMocks
import io.mockk.mockk
import io.mockk.verify
import org.example.application.commands.CommandInvoker
import org.example.application.commands.MoveForwardCommand
import org.example.application.commands.TurnLeftCommand
import org.example.application.commands.TurnRightCommand
import org.example.application.services.RobotInstructionService
import org.example.domain.MarsRobotMovementService
import org.example.domain.entities.Robot
import org.example.domain.values.Orientation
import org.example.domain.values.Position
import org.junit.jupiter.api.Test
import kotlin.test.BeforeTest

class RobotInstructionServiceTest {
    private val robotMovementService = mockk<MarsRobotMovementService>()
    private val invoker = mockk<CommandInvoker>(relaxed = true)
    private var robotInstructionService: RobotInstructionService = RobotInstructionService(robotMovementService, invoker)
    private val robot = Robot(Position(2, 2), Orientation.NORTH)


    @BeforeTest
    fun setup(){
        clearMocks(invoker, robotMovementService)
    }

    @Test
    fun processTurnLeftInstruction(){
        robotInstructionService.processInstruction(robot, 'L')

        verify { invoker.executeCommand(match{it::class == TurnLeftCommand::class}) }
    }

    @Test
    fun processTurnRightInstruction(){
        robotInstructionService.processInstruction(robot, 'R')

        verify { invoker.executeCommand(match{it::class == TurnRightCommand::class}) }
    }

    @Test
    fun processMoveForwardInstruction(){
        robotInstructionService.processInstruction(robot, 'F')

        verify { invoker.executeCommand(match{it::class == MoveForwardCommand::class}) }
    }

    @Test
    fun processInvalidInstruction(){
        robotInstructionService.processInstruction(robot, 'X')

        verify(exactly = 0) { invoker.executeCommand(any()) }
    }

}