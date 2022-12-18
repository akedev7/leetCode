package com.company.medium.sunsetViews

import kotlin.math.max


enum class Direction {
    WEST,
    EAST
}

fun main() {
    getSunsetViews(listOf(3, 5, 4, 4, 3, 1, 3, 2), Direction.EAST).forEach { println(it) }
    println("-----")
    getSunsetViews(listOf(3, 5, 4, 4, 3, 1, 3, 2), Direction.WEST).forEach { println(it) }
}

fun getSunsetViews(inputList: List<Int>, direciton: Direction): List<Int> {
    var maxHeight = 0
    val resultList = mutableListOf<Int>()


    when (direciton) {
        Direction.EAST -> {
            for (i in inputList.size - 1 downTo 0) {
                if (inputList[i] > maxHeight) {
                    resultList.add(i)
                    maxHeight = max(maxHeight, inputList[i])
                }
            }
        }
        Direction.WEST -> {
            for (i in inputList.indices) {
                if (inputList[i] > maxHeight) {
                    resultList.add(i)
                    maxHeight = max(maxHeight, inputList[i])
                }
            }
        }
    }
    return resultList
}
