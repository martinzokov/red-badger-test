package org.example.application.commands

import org.example.domain.RobotMovementService
import org.example.domain.entities.Robot

class MoveForwardCommand(private val robot: Robot, private val service: RobotMovementService): RobotCommand {
    override fun execute() {
        service.moveForward(robot)
    }
}