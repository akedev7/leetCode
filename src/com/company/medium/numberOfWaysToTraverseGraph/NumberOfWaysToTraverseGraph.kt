package com.company.medium.numberOfWaysToTraverseGraph

fun main() {
    println(getNumberOfWayToTraverseGraph(4, 3))
    println(getNumberOfWayToTraverseGraphV2(4, 3))
}


// Time - O(2^(n + m))
// Space - O(n + m)
//Recursive approach
fun getNumberOfWayToTraverseGraph(width: Int, height: Int): Int {
    if (width <= 1 || height <= 1) {
        return 1
    }
    return getNumberOfWayToTraverseGraph(width - 1, height) + getNumberOfWayToTraverseGraph(width, height - 1)
}


// Time - O(n * m)
// Space - O(n * m)
// Dynamic programming
fun getNumberOfWayToTraverseGraphV2(width: Int, height: Int): Int {
    val calculationList = MutableList(height) { MutableList(width) { 0 } }
    repeat(width) { calculationList[0][it] = 1 }
    repeat(height) { calculationList[it][0] = 1}

    for (i in 1 until height) {
        for (j in 1 until width) {
            calculationList[i][j] = calculationList[i - 1][j] + calculationList[i][j - 1]
        }
    }
    return calculationList[height - 1][width - 1]
}

