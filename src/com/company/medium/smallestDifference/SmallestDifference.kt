package com.company.medium.smallestDifference

import kotlin.math.abs

fun main() {
    val pairOfSmallestDiff = getSmallestDifference(listOf(-1, 5, 10, 20, 28, 3), listOf(26, 134, 135, 15, 17))
    println("This is the result: ${pairOfSmallestDiff?.first} ${pairOfSmallestDiff?.second}")
}

fun getSmallestDifference(firstList: List<Int>, secondList: List<Int>): Pair<Int, Int>? {
    val sortedFirstList = firstList.sorted()
    val sortedSecondList = secondList.sorted()

    var i = 0
    var j = 0
    var pairResult: Pair<Int, Int>? = null
    var diff: Int? = null
    while (i < firstList.size && j < secondList.size) {
        val firstNumber = sortedFirstList[i]
        val secondNumber = sortedSecondList[j]
        val distance = abs(firstNumber - secondNumber)
        if (firstNumber == secondNumber) {
            return firstNumber to sortedFirstList[j]
        } else if (firstNumber < secondNumber) {
            i++
        } else {
            j++
        }

        if (diff == null || distance < diff) {
            diff = distance
            pairResult = firstNumber to secondNumber
        }
    }
    return pairResult
}