package org.example.domain.values

enum class Orientation(val value: String) {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    fun left(): Orientation = when (this) {
        NORTH -> WEST
        EAST -> NORTH
        SOUTH -> EAST
        WEST -> SOUTH
    }

    fun right(): Orientation = when (this) {
        NORTH -> EAST
        EAST -> SOUTH
        SOUTH -> WEST
        WEST -> NORTH
    }
}