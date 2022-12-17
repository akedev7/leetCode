package com.company.medium.staircaseTraversal

import kotlin.math.max


fun main() {
    //k = maxStep
    //n = height of recursive stack / element

    //Recursive approach
    // O(k^n)
    // O(n)
    println(getStaircaseTraversal(4, 2))
    println(getStaircaseTraversal(4, 3))
    println()

    //Recursive approach with map to keep track of the value
    // O(k * n) time
    // O(n) space
    println(getStaircaseTraversalV2(4, 2))
    println(getStaircaseTraversalV2(4, 3))
    println()

    //Iterative with dynamic programing with intArray to keep track the value
    // O(k * n) time
    // O(n) space
    println(getStaircaseTraversalV3(4, 2))
    println(getStaircaseTraversalV3(4, 3))
    println()


    //Iterative with sliding window i.e., subtract the first element and add the next element, so it will not be needed to calculate the middle elements again.
    // O(n) time
    // O(n) space
    println(getStaircaseTraversalV4(4, 2))
    println(getStaircaseTraversalV4(4, 3))

}


fun getStaircaseTraversal(height: Int, maxSteps: Int): Int {
    return getStaircaseTraversalHelper(height, maxSteps)
}

fun getStaircaseTraversalHelper(height: Int, maxSteps: Int): Int {
    if (height < 0) {
        return 0
    }

    if (height == 1 || height == 0) {
        return 1
    }
    var numberOfWay = 0
    for (i in height - 1 downTo (height - maxSteps)) {
        numberOfWay += getStaircaseTraversalHelper(i, maxSteps)
    }
    return numberOfWay
}


fun getStaircaseTraversalV2(height: Int, maxSteps: Int): Int {
    val trackingMap = mutableMapOf(0 to 1, 1 to 1)
    return getStaircaseTraversalHelperV2(height, maxSteps, trackingMap)
}

fun getStaircaseTraversalHelperV2(height: Int, maxSteps: Int, trackingMap: MutableMap<Int, Int>): Int {
    if (height < 0) {
        return 0
    }

    if (trackingMap[height] != null) {
        return trackingMap[height]!!
    }

    var numberOfWay = 0
    for (i in height - 1 downTo (height - maxSteps)) {
        numberOfWay += getStaircaseTraversalHelperV2(i, maxSteps, trackingMap)
    }
    trackingMap[height] = numberOfWay
    return numberOfWay
}


fun getStaircaseTraversalV3(height: Int, maxSteps: Int): Int {
    val intArray = IntArray(height + 1) // include base case 0
    intArray[0] = 1  //initial the baseline value
    intArray[1] = 1

    for (i in 2 until intArray.size) {
        var numberOfWay = 0
        val start = max(0, i - maxSteps)
        for (j in start until i) {
            numberOfWay += intArray[j]
        }
        intArray[i] = numberOfWay
    }
    return intArray.last()
}


fun getStaircaseTraversalV4(height: Int, maxSteps: Int): Int {
    var currentNumberOfWay = 0
    val waysToTop = mutableListOf(1) // include base case 0

    for (currentHeight in 1 until height + 1) {
        val startOfWindow = currentHeight - maxSteps - 1
        val endOfWindow = currentHeight - 1
        if (startOfWindow >= 0) {
            currentNumberOfWay -= waysToTop[startOfWindow]
        }
        currentNumberOfWay += waysToTop[endOfWindow]
        waysToTop.add(currentNumberOfWay)
    }
    return waysToTop.last()
}