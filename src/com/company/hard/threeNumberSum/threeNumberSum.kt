package com.company.hard.threeNumberSum

fun main() {
    getThreeNumberSum(listOf(12, 3, 1, 2, -6, 5, -8, 6), 0)
}

fun getThreeNumberSum(list: List<Int>, expectedSum: Int): List<List<Int>> {
    val sorted = list.sorted()
    val resultList = mutableListOf<List<Int>>()
    for (i in 0..sorted.size) {
        var startPointer = i + 1
        var endPointer = sorted.size - 1
        while (startPointer < endPointer) {
            val currentSum = sorted[i] + sorted[startPointer] + sorted[endPointer]
            if (currentSum == expectedSum) {
                resultList.add(listOf(sorted[i], sorted[startPointer], sorted[endPointer]))
                startPointer++
            } else if (currentSum > expectedSum) {
                endPointer--
            } else {
                startPointer++
            }
        }
    }
    return resultList
}
