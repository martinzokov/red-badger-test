package org.example.application

class MissionCommandProcessor() {
//    private lateinit var missionService: MarsMissionService
//    private lateinit var currentRobot: Robot
//
//    fun startMission(mapBounds: String) {
//        val (xBound, yBound) = mapBounds.split(" ")
//        missionService = MarsMissionService(Position(xBound.toInt(), yBound.toInt()))
//    }
//
//    fun deployRobot(startingPosition: String){
//        val (x, y, orientation) = parseStartingPosition(startingPosition)
//        currentRobot = missionService.deployRobot(Position(x, y), orientation)
//    }
//
//    fun processRobotCommandString(commands: String){
//        for(command in commands){
//            val currentCommand = when(command){
//                'L' -> TurnLeftCommand(currentRobot)
//                'R' -> TurnRightCommand(currentRobot)
//                'F' -> MoveForwardCommand(missionService, currentRobot)
//                else -> null
//            }
//            currentCommand?.execute() ?: println("unsupported command")
//        }
//    }
//
//    private fun parseStartingPosition(robotStart: String): Triple<Int, Int, Orientation>{
//        val (xPos, yPos, orientation) = robotStart.split(" ")
//        return Triple(xPos.toInt(), yPos.toInt(), Orientation.valueOf(orientation))
//    }
}