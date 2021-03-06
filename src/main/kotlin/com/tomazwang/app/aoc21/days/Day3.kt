package com.tomazwang.app.aoc21.days

import com.tomazwang.app.aoc21.Day
import com.tomazwang.app.aoc21.Runner
import com.tomazwang.app.aoc21.utils.InputData
import kotlin.math.pow

/**
 * Created by TomazWang on 2021/12/27.
 *
 *
 * @author Tomaz Wang
 * @since 2021/12/27
 **/

class Day3 : Day(3, "Binary Diagnostic") {
    
    override fun part1(input: InputData): String {
        
        
        val bits = mutableListOf<Bit>()
        
        val lines = input.lines.filter { it.isNotBlank() }
        
        
        lines.forEach { line ->
            repeat(line.length) { idx ->
                
                val bit = bits.getOrNull(idx) ?: Bit().also { bits.add(idx, it) }
                
                when (line[idx]) {
                    '0' -> bit.addZero()
                    '1' -> bit.addOne()
                    else -> throw IllegalArgumentException()
                }
            }
        }
        
        val gammaBin = bits.map { it.most }
        val epsilonBin = bits.map { it.least }
        
        val gamma = gammaBin.joinToString("").toInt(2)
        val epsilon = epsilonBin.joinToString("").toInt(2)
        
        return (gamma * epsilon).toString()
    }
    
    override fun part2(input: InputData): String {
        
        val lines = input.lines.filter { it.isNotBlank() }
        
        val oxygen = calAir(lines, true, 1)
        val co2 = calAir(lines, false, 0)
        
        return (oxygen * co2).toString()
        
    }
    
    
    private fun calAir(lines: List<String>, useMost: Boolean, tieBreaker: Int): Int {
    
        val bitsCount = lines.first().length
        
        var remainLines = lines
        for (index in 0 until bitsCount) {
        
            if (remainLines.size == 1) {
                break
            }
        
            val bit = Bit()
        
            remainLines.forEach { line ->
                when (line[index]) {
                    '0' -> bit.addZero()
                    '1' -> bit.addOne()
                    else -> throw IllegalArgumentException()
                }
            }
    
            remainLines = if (bit.ones == bit.zeros) {
                remainLines.filter { it[index].toString() == tieBreaker.toString() }
            } else {
                val next = if (useMost) bit.most else bit.least
                remainLines.filter { it[index].toString() == next.toString() }
            }
        }
        
        return remainLines.first().toInt(2)
    }
    
    
    data class Bit(private var _zeros: Int = 0, private var _ones: Int = 0) {
        val ones: Int
            get() = _ones
        
        val zeros: Int
            get() = _zeros
        
        val most: Int
            get() = if (_ones > _zeros) 1 else 0
        
        val least: Int
            get() = if (_ones > _zeros) 0 else 1
        
        fun addOne() {
            _ones += 1
        }
        
        fun addZero() {
            _zeros += 1
        }
        
        override fun toString(): String = "(zero: $_zeros, one: $_ones)"
    }
}


fun main() {
    Runner.run(Day3())
}