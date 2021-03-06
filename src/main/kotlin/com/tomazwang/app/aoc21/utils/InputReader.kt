package com.tomazwang.app.aoc21.utils

import java.io.File

/**
 * Created by TomazWang on 2021/12/24.
 *
 *
 * @author Tomaz Wang
 * @since 2021/12/24
 **/

object InputReader {
    
    fun readInput(day: Int, part: Int): InputData {
        return InputData(readInputAsString(day, part))
    }
    
    
    fun readInputAsString(day: Int, part: Int = 1): String {
        return readInputAsFile(day, part).readText()
    }
    
    fun readInputAsList(day: Int, part: Int = 1): List<String> {
        return readInputAsFile(day, part).readLines()
    }
    
    private fun readInputAsFile(day: Int, part: Int = 1): File {
        val fileName = "day${day}-pt${1}.txt"
        return fromResource(fileName)
    }
    
    
    private fun fromResource(fileName: String): File {
        return File(javaClass.classLoader.getResource("input/$fileName").toURI())
    }
}


data class InputData(val raw: String) {
    val lines
        get() = raw.lines().filter { it.isNotBlank() }
}