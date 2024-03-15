package org.example.application.commands

class RobotCommandInvoker {
    fun executeCommand(command: RobotCommand) {
        command.execute()
    }
}