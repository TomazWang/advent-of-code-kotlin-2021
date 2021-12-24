package com.tomazwang.app.aoc21.days

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
        val result = Day1().partOne(input)
        
        
        
        // -- Assert
        val expect = 7
        
        result shouldBe expect
        
        
    }
}