package org.example.application.commands

import org.example.domain.entities.Robot

class TurnLeftCommand(private val robot: Robot): RobotCommand {
    override fun execute() {
        robot.turnLeft()
    }
}