package com.company.medium.singleCycleCheck

fun main() {
    println(hasSingleCycleCheck(listOf(2, 3, 1, -4, -4, 2)))
}

const val START_INDEX = 0

// O(n) time | O(1) space
fun hasSingleCycleCheck(inputList: List<Int>): Boolean {
    var currentIndex = START_INDEX
    var hopCount = 0
    while (hopCount < inputList.size) {
        if (currentIndex == START_INDEX && hopCount != 0) {
            return false
        }
        currentIndex = getNextHopElement(currentIndex, inputList)
        hopCount++
    }
    return currentIndex == START_INDEX
}

private fun getNextHopElement(currentIndex: Int, inputList: List<Int>): Int {
    var jumpRange = (currentIndex + inputList[currentIndex])
    if (jumpRange > inputList.size - 1) {
        return (jumpRange % (inputList.size - 1)) - 1
    } else if (jumpRange < 0) {
        return inputList.size + jumpRange
    }
    return jumpRange
}
