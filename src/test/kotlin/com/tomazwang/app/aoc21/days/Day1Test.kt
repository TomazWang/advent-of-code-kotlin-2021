package com.tomazwang.app.aoc21.days

import com.tomazwang.app.aoc21.utils.InputData
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/**
 * Created by TomazWang on 2021/12/24.
 *
 *
 * @author Tomaz Wang
 * @since 2021/12/24
 */

internal class Day1Test {
    
    
    @Test
    fun part1Sample() {
        
        // -- Arrange
        
        val input = listOf(
            "199",
            "200",
            "208",
            "210",
            "200",
            "207",
            "240",
            "269",
            "260",
            "263",
        )
        
        
        // -- Action
        val result = Day1().part1(InputData(input.joinToString("\n")))
        
        
        // -- Assert
        val expect = 7.toString()
        
        result shouldBe expect
    }
    
    
    @Test
    fun part2Sample() {
        
        val input = listOf(
            "199",
            "200",
            "208",
            "210",
            "200",
            "207",
            "240",
            "269",
            "260",
            "263",
        )
        
        
        val result = Day1().part2(
            InputData(input.joinToString("\n"))
        )
        
        
        val expect = 5.toString()
        
        result shouldBe expect
    }
}