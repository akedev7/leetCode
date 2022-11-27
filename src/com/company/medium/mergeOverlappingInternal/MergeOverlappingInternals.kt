package com.company.medium.mergeOverlappingInternal

import kotlin.math.max


fun main() {
    val mergeOverlappingIntervals = getMergeOverlappingIntervals(listOf(
            listOf(1, 2),
            listOf(3, 5),
            listOf(4, 7),
            listOf(6, 8),
            listOf(9, 10)
    ))
    println(mergeOverlappingIntervals)
}

fun getMergeOverlappingIntervals(inputList: List<List<Int>>): List<List<Int>> {
    val resultList = mutableListOf<List<Int>>()
    for (i in inputList.indices
    ) {
        if (resultList.isEmpty() || isNotOverlapped(inputList, i, resultList)) {
            resultList.add(listOf(inputList[i][0],inputList[i][1]))
        } else {
            mergeOverlappedPairOfInt(resultList, inputList, i)
        }
    }
    return resultList
}

private fun mergeOverlappedPairOfInt(resultList: MutableList<List<Int>>, inputList: List<List<Int>>, i: Int) {
    resultList[resultList.lastIndex] = listOf(resultList.last()[0], max(inputList[i][1], resultList.last()[1]))
}

private fun isNotOverlapped(inputList: List<List<Int>>, i: Int, resultList: MutableList<List<Int>>) =
        inputList[i][0] > resultList.last()[1]
