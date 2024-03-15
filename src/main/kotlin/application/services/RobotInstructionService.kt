package org.example.application.services

import org.example.application.commands.*
import org.example.domain.RobotMovementService
import org.example.domain.entities.Robot

class RobotInstructionService(private val movementService: RobotMovementService, private val invoker: CommandInvoker) {

    fun processInstruction(robot: Robot, instruction: Char){
        val command: RobotCommand? = when(instruction){
            'L' -> TurnLeftCommand(robot)
            'R' -> TurnRightCommand(robot)
            'F' -> MoveForwardCommand(robot, movementService)
            else -> null
        }

         command?.also {
             invoker.executeCommand(it)
         }
    }
}