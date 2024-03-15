package org.example.application.commands

interface CommandInvoker {
    fun executeCommand(command: RobotCommand)
}