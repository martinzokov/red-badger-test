package org.example.application.commands

import org.example.domain.entities.Robot

class TurnRightCommand(private val robot: Robot): RobotCommand {
    override fun execute() {
        robot.turnRight()
    }
}