package com.tomazwang.app.aoc21.days

import com.tomazwang.app.aoc21.utils.InputData
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/**
 * Created by TomazWang on 2021/12/27.
 *
 *
 * @author Tomaz Wang
 * @since 2021/12/27
 */

internal class Day2Test {
    
    @Test
    fun part1() {
        
        val input = """
            forward 5
            down 5
            forward 8
            up 3
            down 8
            forward 2
        """.trimIndent()
        
        
        val inputData = InputData(input)
        
        
        // Action
        
        
        val result = Day2().part1(inputData)
        
        
        // Assert
        val expect = 150.toString()
        
        result shouldBe expect
        
        
    }
    
    @Test
    fun part2() {
    
    
        val input = """
            forward 5
            down 5
            forward 8
            up 3
            down 8
            forward 2
        """.trimIndent()
    
    
        val inputData = InputData(input)
    
        val result = Day2().part2(inputData)
    
        
        result shouldBe "900"
    
    }
}