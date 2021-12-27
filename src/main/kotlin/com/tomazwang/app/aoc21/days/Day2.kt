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
        
        val init = Cruise()
        
        val finalCruise = instructions.fold(init) { currentCruise, nextInstruct ->
            val (direction, step) = nextInstruct
            currentCruise.move(direction, step)
        }
        
        return finalCruise.result.toString()
    }
    
    override fun part2(input: InputData): String {
        val instructions = input.lines.map(::convertData)
        
        val init = Cruise(isAimEnable = true)
        
        val finalCruise = instructions.fold(init) { currentCruise, nextInstruct ->
            val (direction, step) = nextInstruct
            currentCruise.move(direction, step)
        }
        
        return finalCruise.result.toString()
    }
    
    
    private fun convertData(line: String): Pair<Direction, Int> {
        
        val (directionStr, stepStr) = line.split(" ", ignoreCase = true)
        
        val direction = Direction.fromString(directionStr)
        val step = stepStr.toInt()
        
        return direction to step
    }
}


data class Position(val horizontal: Int, val depth: Int) {
    override fun toString(): String = "Position: $horizontal, $depth"
}

data class Cruise(val pos: Position = Position(0, 0), val aim: Int = 0, val isAimEnable: Boolean = false) {
    val result: Int
        get() = pos.depth * pos.horizontal
    
    fun move(direction: Direction, step: Int): Cruise {
        
        return when (direction) {
            Direction.Down -> {
                val newPos = if (isAimEnable) pos else Position(pos.horizontal, pos.depth + step)
                val newAim = if (isAimEnable) aim + step else 0
                // println("down $step: move to $newPos, aim on $newAim")
                Cruise(
                    pos = newPos,
                    aim = newAim,
                    isAimEnable = isAimEnable
                )
            }
            Direction.Up -> {
    
                val newPos = if (isAimEnable) pos else Position(pos.horizontal, pos.depth - step)
                val newAim = if (isAimEnable) aim - step else 0
                // println("up $step: move to $newPos, aim on $newAim")
                
                Cruise(
                    pos = newPos,
                    aim = newAim,
                    isAimEnable = isAimEnable
                )
            }
            Direction.Forward -> {
                val newHor = pos.horizontal + step
                val newDepth = pos.depth + aim * step
                val newPos = Position(newHor, newDepth)
    
                val newAim = if (isAimEnable) aim else 0
    
                // println("forward $step: move to $newPos, aim on $newAim")
                
                Cruise(
                    pos = newPos,
                    aim = newAim,
                    isAimEnable = isAimEnable
                )
            }
        }
    }
}


sealed class Direction {
    
    object Forward : Direction()
    object Up : Direction()
    object Down : Direction()
    
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

