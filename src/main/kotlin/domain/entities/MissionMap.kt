package org.example.domain.entities

import org.example.domain.values.Orientation
import org.example.domain.values.Position

interface MissionMap {
    fun scentExistsAt(position: Position, orientation: Orientation): Boolean
    fun isWithinBounds(position: Position): Boolean
    fun addScent(position: Position, orientation: Orientation)
}