package org.example.application.commands

class RobotCommandInvoker: CommandInvoker {
    override fun executeCommand(command: RobotCommand) {
        command.execute()
    }
}