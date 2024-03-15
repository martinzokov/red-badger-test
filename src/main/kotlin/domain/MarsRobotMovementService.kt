package org.example.domain

import org.example.domain.entities.MissionMap
import org.example.domain.entities.Robot
import org.example.domain.values.RobotStatus

class MarsRobotMovementService(private val map: MissionMap): RobotMovementService {

    override fun moveForward(robot: Robot) {
        val lastKnownPosition = robot.position
        if (!map.scentExistsAt(lastKnownPosition, robot.orientation)) {
            val nextPosition = robot.getNextPosition()
            if (!map.isWithinBounds(nextPosition)) {
                robot.status(RobotStatus.LOST)
                map.addScent(lastKnownPosition, robot.orientation)
            } else {
                robot.position = nextPosition
            }
        }
    }
}