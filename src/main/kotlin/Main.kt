package org.example

import org.example.application.MarsMissionRunner
import org.example.domain.values.Orientation

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Enter map upper right corner bound in format \'X Y\' ")
    val (mapXBound, mapYBound) = readln()!!.split(' ')
    val missionRunner = MarsMissionRunner(mapXBound.toInt(), mapYBound.toInt())
    var missionActive = true

    while(missionActive){
        println("Deploy robot? \'Y/N\' ")
        val shouldDeployRobot = readln()
        missionActive = shouldDeployRobot.uppercase() == "Y"
        if(!missionActive) {
            continue
        }

        println("Enter robot deployment point in format \'X Y O\' | O is orientation - one of E, W, N, S ")
        val (startX, startY, orientationInput) = readln()!!.split(' ')
        val orientation = Orientation.fromString(orientationInput)
        if(orientation != null){
            missionRunner.deployRobot(startX.toInt(), startY.toInt(), orientation)
        } else {
            continue
        }

        println("Enter robot instructions as a string. Accepted instructions are L - turn left, R - turn right, F - move forward")
        val instructions = readln()
        missionRunner.receiveRobotInstructions(instructions)

        val report = missionRunner.currentRobot.getReport()
        println("Robot status is ${report.robotStatus.toString()} and last known position is ${report.position.xPosition} ${report.position.yPosition} ${report.orientation.value}")
    }

}