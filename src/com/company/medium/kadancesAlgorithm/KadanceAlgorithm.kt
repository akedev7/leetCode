package com.company.medium.kadancesAlgorithm

import kotlin.math.max

fun main() {
    //Find longest adjacent subarray which sum the most value
    println(kadanceAlgorithm(mutableListOf(3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4)))
}

//Dynamic programming to continuously sum up the sub-array or use the current element
fun kadanceAlgorithm(inputList: MutableList<Int>): Int {
    var currentMax = 0
    for (i in 1 until inputList.size) {
        inputList[i] = max(inputList[i], inputList[i - 1] + inputList[i])
        if (inputList[i] > currentMax) {
            currentMax = inputList[i]
        }
    }
    return currentMax
}
