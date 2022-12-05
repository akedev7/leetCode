package com.company.medium.mininumPassesOfMatrix

import java.util.concurrent.ArrayBlockingQueue

fun main() {
    println(getMinimumPassesOfMatrix(mutableListOf(
            mutableListOf(0, -1, -3, 2, 0),
            mutableListOf(0, -2, -5, -1, -3),
            mutableListOf(3, 0, 0, -4, -1),
    )))
}

typealias Position = Pair<Int, Int>
fun getMinimumPassesOfMatrix(matrix: MutableList<MutableList<Int>>): Int {
    val nextQueue = getPositivePosition(matrix)
    var count = 0
    while (!nextQueue.isEmpty()) {
        val currentQueue = nextQueue.copy()
        nextQueue.clear()
        val element = currentQueue.poll()
        val neighbors = getAllNeighbors(element, matrix)
        flipNegativeNeighbors(neighbors, matrix, nextQueue)
        count++
    }
    return count - 1 //Due to it will find the empty queue when get to the next loop therefore it needs to deduct at the end
}

private fun ArrayBlockingQueue<Position>.copy(): ArrayBlockingQueue<Position> {
    val queue = ArrayBlockingQueue<Position>(20)
     this.forEach {
        queue.add(it)
    }
    return queue
}

private fun getPositivePosition(matrix: MutableList<MutableList<Int>>): ArrayBlockingQueue<Position> {
    val queue = ArrayBlockingQueue<Position>(20)
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] > 0) {
                queue.add(Position(i, j))
            }
        }
    }
    return queue
}

fun flipNegativeNeighbors(neighbors: List<Pair<Int, Int>>, matrix: MutableList<MutableList<Int>>, queue: ArrayBlockingQueue<Position>) {
    neighbors.forEach {
        if (matrix[it.first][it.second] < 0) {
            matrix[it.first][it.second] *= -1
            queue.add(Position(it.first, it.second))
        }
    }
}

private fun getAllNeighbors(element: Position, matrix: MutableList<MutableList<Int>>): List<Position> {
    val list = mutableListOf<Position>()
    if (element.first > 0) {
        list.add(Position(element.first - 1, element.second))
    }

    if (element.first < matrix.size - 1) {
        list.add(Position(element.first + 1, element.second))
    }

    if (element.second > 0) {
        list.add(Position(element.first, element.second - 1))
    }

    if (element.second < matrix[0].size - 1) {
        list.add(Position(element.first, element.second + 1))
    }
    return list
}
