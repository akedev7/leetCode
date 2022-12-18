package com.company.medium.threeNumberSort

fun main() {
    getThreeNumberSort(mutableListOf(1, 0, 0, -1, -1, 0, 1, 1), listOf(0, 1, -1)).forEach {
        print(it)
    }
    println()
    getThreeNumberSortV2(mutableListOf(1, 0, 0, -1, -1, 0, 1, 1), listOf(0, 1, -1)).forEach {
        print(it)
    }
}

// O(n) time with 2 loops
fun getThreeNumberSort(inputList: MutableList<Int>, order: List<Int>): List<Int> {

    //Move all the element of the first order to the left
    var firstIndex = 0
    for (i in inputList.indices) {
        if (inputList[i] == order[0]) {
            inputList.swap(i, firstIndex)
            firstIndex++
        }
    }

    //Move all the element of the last order to the right
    var lastIndex = inputList.size - 1
    for (i in inputList.size - 1 downTo 0) {
        if (inputList[i] == order[2]) {
            inputList.swap(i, lastIndex)
            lastIndex--
        }
    }

    //Then the rest will be in the middle
    return inputList
}

// O(n) time with single loop
fun getThreeNumberSortV2(inputList: MutableList<Int>, order: List<Int>): List<Int> {
    var pointer = 0
    var firstIndex = 0
    var lastIndex = inputList.size - 1

    while (pointer <= lastIndex) {
        if (inputList[pointer] == order[0]) {
            inputList.swap(pointer, firstIndex)
            firstIndex++
        } else if (inputList[pointer] == order[2]) {
            inputList.swap(pointer, lastIndex)
            lastIndex--
        }
        pointer++
    }

    return inputList
}

private fun MutableList<Int>.swap(firstIndex: Int, secondIndex: Int) {
    val temp = this[firstIndex]
    this[firstIndex] = this[secondIndex]
    this[secondIndex] = temp
}
