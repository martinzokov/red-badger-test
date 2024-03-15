package org.example.domain.entities

import org.example.domain.values.Orientation
import org.example.domain.values.Position
import org.example.domain.values.RobotStatus

class Robot(var position: Position, var orientation: Orientation, var status: RobotStatus = RobotStatus.ALIVE) {
    fun getNextPosition() = when(orientation){
            Orientation.NORTH -> Position(position.xPosition, position.yPosition + 1)
            Orientation.SOUTH -> Position(position.xPosition, position.yPosition - 1)
            Orientation.EAST -> Position(position.xPosition + 1, position.yPosition)
            Orientation.WEST -> Position(position.xPosition - 1, position.yPosition)
        }

    fun status(newStatus: RobotStatus) {
        status = newStatus
    }

    fun isAlive(): Boolean = status == RobotStatus.ALIVE

    fun turnRight(){
        orientation = orientation.right()
    }

    fun turnLeft(){
        orientation = orientation.left()
    }
}