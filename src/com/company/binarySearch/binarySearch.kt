package com.company.binarySearch


fun main() {
    println(getBinarySearchV2(listOf(0, 1, 21, 33, 45, 45, 61, 71, 72, 73), 1))
}


fun getBinarySearchV2(list: List<Int>, targetNumber: Int): Int {
    return getBinarySearchHelper(list, targetNumber, 0, list.size - 1)
}

fun getBinarySearchHelper(list: List<Int>, targetNumber: Int, leftPointer: Int, rightPointer: Int): Int {

    if (leftPointer > rightPointer) {
        return -1
    }

    val middle = (rightPointer + leftPointer) / 2
    return if (list[middle] == targetNumber) {
        middle
    } else if (targetNumber < list[middle]) {
        getBinarySearchHelper(list, targetNumber, leftPointer, middle - 1)
    } else {
        getBinarySearchHelper(list, targetNumber, middle + 1, rightPointer)
    }
}

