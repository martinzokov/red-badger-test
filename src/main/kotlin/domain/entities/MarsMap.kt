package org.example.domain.entities

import org.example.domain.values.Orientation
import org.example.domain.values.Position
import org.example.domain.values.Scent

class MarsMap(private val mapBoundary: Position): MissionMap {
    private val scents: MutableList<Scent> = mutableListOf()

    override fun scentExistsAt(position: Position, orientation: Orientation): Boolean =
        scents.any { it.position == position && it.orientation == orientation }

    override fun isWithinBounds(position: Position): Boolean {
        return position.xPosition > mapBoundary.xPosition
                || position.yPosition > mapBoundary.yPosition
                || position.xPosition < 0
                || position.yPosition < 0
    }

    override fun addScent(position: Position, orientation: Orientation) {
        scents.add(Scent(position, orientation))
    }
}