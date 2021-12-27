package com.tomazwang.app.aoc21

import com.tomazwang.app.aoc21.utils.InputData
import com.tomazwang.app.aoc21.utils.InputReader

/**
 * Created by TomazWang on 2021/12/24.
 *
 *
 * @author Tomaz Wang
 * @since 2021/12/24
 **/

abstract class Day(
    val dayNum: Int,
    val name: String,
) {
    
    abstract fun part1(input: InputData): String
    
    abstract fun part2(input: InputData): String
    
    
    /**
     * @param part 1, 2, 0. 0 == both
     */
    fun run(part: Int = 0) {
        
        println("Running Day $dayNum: $name")
        
        when (part) {
            1 -> runPart1()
            2 -> runPart2()
            0 -> {
                runPart1()
                runPart2()
            }
            else -> throw IllegalArgumentException()
        }
    }
    
    private fun runPart1() {
        
        println("--- PART ONE ---")
        val input = InputReader.readInput(dayNum, 1)
        
        try {
            val result = part1(input)
            println("Result: $result")
        } catch (e: NotImplementedError) {
            println("<not implement>")
        }
    }
    
    private fun runPart2() {
        println("--- PART TWO ---")
        val input = InputReader.readInput(dayNum, 2)
        try {
            val result = part2(input)
            println("Result: $result")
        } catch (e: NotImplementedError) {
            println("<not implement>")
        }
    }
}
