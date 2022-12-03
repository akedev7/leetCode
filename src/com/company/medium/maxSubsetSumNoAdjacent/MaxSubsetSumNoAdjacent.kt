package com.company.medium.maxSubsetSumNoAdjacent

import kotlin.math.max

fun main() {
//    getMaxSubSetSumNoAdjacent(listOf(7, 10, 12, 7, 9, 14)).forEach { println(it) }
    getMaxSubSetSumNoAdjacentV2(mutableListOf(7, 10, 12, 7, 9, 14)).forEach { println(it) }
}


// Time complexity: O(n)
// Space complexity: O(n)
fun getMaxSubSetSumNoAdjacent(inputList: List<Int>): List<Int> {
    val outputList = MutableList(inputList.size) { 0 }
    outputList[0] = inputList[0]
    outputList[1] = max(inputList[0], inputList[1])

    for (i in 2 until outputList.size) {
        outputList[i] = max(outputList[i - 1], outputList[i - 2] + inputList[i])
    }
    return outputList
}

// Time complexity: O(n)
// Space complexity: O(1)
fun getMaxSubSetSumNoAdjacentV2(inputList: MutableList<Int>): List<Int> {
    inputList[1] = max(inputList[0], inputList[1])
    var first = inputList[0] //Dynamic programming by caching input along the way
    var second = inputList[1]

    for (i in 2 until inputList.size) {
        inputList[i] = max(second, first + inputList[i])
        first = second
        second = inputList[i]
    }
    return inputList
}

