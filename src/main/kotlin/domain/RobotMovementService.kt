package org.example.domain

import org.example.domain.entities.Robot

interface RobotMovementService {
    fun moveForward(robot: Robot)
}