package org.example.application

import org.example.application.commands.CommandInvoker
import org.example.application.commands.RobotCommandInvoker
import org.example.application.services.RobotInstructionService
import org.example.domain.MarsRobotMovementService
import org.example.domain.entities.MarsMap
import org.example.domain.entities.Robot
import org.example.domain.values.Orientation
import org.example.domain.values.Position
import org.example.domain.values.RobotReport

class MarsMissionRunner(mapWidth: Int, mapHeight: Int) {
    private val robotInstructionService: RobotInstructionService
    lateinit var currentRobot: Robot

    init {
        val map = MarsMap(Position(mapWidth, mapHeight))
        val movementService = MarsRobotMovementService(map)
        val invoker: CommandInvoker = RobotCommandInvoker()
        robotInstructionService = RobotInstructionService(movementService, invoker)
    }

    fun deployRobot(startX: Int, startY: Int, orientation: Orientation){
        currentRobot = Robot(Position(startX, startY), orientation)
    }

    fun receiveRobotInstructions(instructions: String): RobotReport {
        for(instruction in instructions){
            robotInstructionService.processInstruction(currentRobot, instruction)
        }
        return currentRobot.getReport()
    }
}