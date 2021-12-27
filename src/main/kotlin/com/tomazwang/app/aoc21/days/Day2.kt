package com.tomazwang.app.aoc21.days

import com.tomazwang.app.aoc21.Day
import com.tomazwang.app.aoc21.Runner
import com.tomazwang.app.aoc21.utils.InputData

/**
 * Created by TomazWang on 2021/12/27.
 *
 *
 * @author Tomaz Wang
 * @since 2021/12/27
 **/

class Day2 : Day(2, name = "Dive!") {
    
    
    override fun part1(input: InputData): String {
        val instructions = input.lines.map(::convertData)
        
        val pos = instructions.fold(Position(0, 0)) { acc, curr ->
            curr.first.move(acc, curr.second)
        }
        
        return pos.result.toString()
    }
    
    override fun part2(input: InputData): String {
        TODO("Not yet implemented")
    }
    
    
    private fun convertData(line: String): Pair<Direction, Int> {
        
        val (directionStr, stepStr) = line.split(" ", ignoreCase = true)
        
        val direction = Direction.fromString(directionStr)
        val step = stepStr.toInt()
        
        return direction to step
    }
}


data class Position(val horizontal: Int, val depth: Int) {
    val result: Int
        get() = depth * horizontal
}

sealed class Direction {
    
    abstract fun move(current: Position, step: Int): Position
    
    object Forward : Direction() {
        override fun move(current: Position, step: Int) = Position(current.horizontal + step, current.depth)
    }
    
    
    object Up : Direction() {
        override fun move(current: Position, step: Int) = Position(current.horizontal, current.depth - step)
    }
    
    object Down : Direction() {
        override fun move(current: Position, step: Int) = Position(current.horizontal, current.depth + step)
    }
    
    companion object {
        fun fromString(name: String): Direction {
            return when (name) {
                "forward" -> Forward
                "up" -> Up
                "down" -> Down
                else -> throw IllegalArgumentException()
            }
        }
    }
}


fun main() {
    Runner.run(Day2())
}

