package com.company.medium.longestPeak

fun main() {
    println(getLongestPeak(listOf(1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3)))
}

fun getLongestPeak(inputList: List<Int>): Int {

    var peakPosition = mutableListOf<Int>()
    for (i in 2 until inputList.size) {
        val midPosition = i - 1
        if (inputList[i - 2] < inputList[midPosition] && inputList[midPosition] > inputList[i]) {
            peakPosition.add(midPosition)
        }
    }

    var currentLongestPeakRange = 0
    peakPosition.forEach {
        var peakRangeCount = 1 //count the one from the middle first.
        var leftPointer = it
        var rightPointer = it
        while (leftPointer > 0 && inputList[leftPointer - 1] < inputList[leftPointer]) {
            peakRangeCount++
            leftPointer++
        }
        while (rightPointer < inputList.size - 1 && inputList[rightPointer] > inputList[rightPointer + 1]) {
            peakRangeCount++
            rightPointer++
        }

        if (peakRangeCount > currentLongestPeakRange) {
            currentLongestPeakRange = peakRangeCount
        }
    }
    return currentLongestPeakRange
}
