package com.company.medium.monotonicArray

fun main() {
    println(isMonotonicArray(listOf(-1, -5, -10, -1100, -1100, -1101, -1102, -9001)))
    println(isMonotonicArray(listOf(1, 5, 10, 1100, 1100, 1101, 1102, 9001)))
}

fun isMonotonicArray(inputList: List<Int>): Boolean {
    var increasingArray = true
    var decreasingArray = true

    for (i in 1 until inputList.size) {

        val firstElement = inputList[i - 1]
        val secondElement = inputList[i]

        if (firstElement < secondElement) {
            decreasingArray = false
        } else if (firstElement > secondElement) {
            increasingArray = false
        }
    }
    return increasingArray || decreasingArray
}
