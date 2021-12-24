package com.tomazwang.app.aoc21.days

import com.tomazwang.app.aoc21.Day
import com.tomazwang.app.aoc21.Runner
import com.tomazwang.app.aoc21.utils.InputData

/**
 * Created by TomazWang on 2021/12/24.
 *
 *
 * @author Tomaz Wang
 * @since 2021/12/24
 **/

class Day1 : Day(1, "Sonar Sweep") {
    
    override fun part1(input: InputData): String {
        val inputStrings = input.lines
        return countIncrease(inputStrings.map { it.toInt() }).toString()
    }
    
    override fun part2(input: InputData): String {
    
        val inputStrings = input.lines
        
        
        val distances = inputStrings.map { it.toInt() }
        val windows = (0 until (distances.size - 2)).map { listOf(distances[it], distances[it + 1], distances[it + 2]) }
    
        val sums = windows.map { it.sum() }
    
        return countIncrease(sums).toString()
    }
    
    private fun countIncrease(input: List<Int>): Int {
        val result = input.fold((null to 0)) { acc: Pair<Int?, Int>, item ->
            
            val (prev, currentCount) = acc
            
            when {
                prev == null -> item to currentCount
                item > prev -> item to currentCount + 1
                else -> item to currentCount
            }
        }
        
        return result.second
    }
}


fun main() {
    Runner.run(Day1())
}