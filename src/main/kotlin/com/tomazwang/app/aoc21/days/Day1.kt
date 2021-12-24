package com.tomazwang.app.aoc21.days

import com.tomazwang.app.aoc21.utils.InputReader

/**
 * Created by TomazWang on 2021/12/24.
 *
 *
 * @author Tomaz Wang
 * @since 2021/12/24
 **/

class Day1 {
    
    fun partOne(input: List<String>): Int {
        return countIncrease(input.map { it.toInt()} )
    }
    
    fun part2(input: List<String>): Int {
        
        val distances = input.map { it.toInt() }
        val windows = (0 until (distances.size - 2)).map { listOf(distances[it], distances[it + 1], distances[it + 2]) }
        
        val sums = windows.map { it.sum() }
        
        return countIncrease(sums)
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
    
    val day = Day1()
    
    
    val partOneInput = InputReader.readInputAsList(1, 1)
    val result1 = day.partOne(partOneInput)
    print("Day 1 part 1 - result = $result1")
    
    
    val part2Input = InputReader.readInputAsList(1, 2)
    val result2 = day.part2(part2Input)
    print("Day 1 part 2 - result = $result2")
}