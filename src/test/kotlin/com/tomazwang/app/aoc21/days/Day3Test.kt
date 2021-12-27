package com.tomazwang.app.aoc21.days

import com.tomazwang.app.aoc21.utils.InputData
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

/**
 * Created by TomazWang on 2021/12/27.
 *
 *
 * @author Tomaz Wang
 * @since 2021/12/27
 */

internal class Day3Test {
    
    @Test
    fun part1() {
        
        val inputRaw = """
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010
        """.trimIndent()
        
        val input = InputData(inputRaw)
        
        val result = Day3().part1(input)
        
        
        result shouldBe 198.toString()
        
    }
    
    @Test
    fun part2() {
    
    
        val inputRaw = """
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010
        """.trimIndent()
    
        val input = InputData(inputRaw)
    
        val result = Day3().part2(input)
    
    
        result shouldBe 230.toString()
    }
}