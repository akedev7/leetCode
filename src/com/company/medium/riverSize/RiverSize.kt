package com.company.medium.riverSize

import java.util.*

fun main() {
    getRiverSizes(listOf(
            listOf(1, 0, 0, 1, 0),
            listOf(1, 0, 1, 0, 0),
            listOf(0, 0, 1, 0, 1),
            listOf(1, 0, 1, 0, 1),
            listOf(1, 0, 1, 1, 0)
    )).forEach { println(it) }
}

fun getRiverSizes(matrix: List<List<Int>>): List<Int> {
    val visitedMatrix = MutableList(matrix.size) { MutableList(matrix[0].size) { false } }
    val resultList: MutableList<Int> = mutableListOf()
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (visitedMatrix[i][j]) {
                continue
            }
            traverseGraph(i, j, matrix, visitedMatrix, resultList)
        }
    }
    return resultList
}

typealias Coordinate = Pair<Int, Int>

fun traverseGraph(i: Int, j: Int, matrix: List<List<Int>>, visitedMatrix: MutableList<MutableList<Boolean>>, resultList: MutableList<Int>) {
    var riverSize = 0
    val stack = Stack<Coordinate>() //For depthFirstSearch
    stack.add(Coordinate(i, j))
    while (!stack.isEmpty()) {
        val coordinate = stack.pop()
        if (visitedMatrix[coordinate.first][coordinate.second]) {
            continue
        }
        visitedMatrix[coordinate.first][coordinate.second] = true
        if (matrix[coordinate.first][coordinate.second] == 0) {
            continue
        }
        riverSize += 1
        val neighborsNodes = getNeighborsNodes(coordinate.first, coordinate.second, visitedMatrix)
        neighborsNodes.forEach {
            stack.add(it)
        }
    }

    if (riverSize > 0) {
        resultList.add(riverSize)
    }
}

fun getNeighborsNodes(i: Int, j: Int, visitedMatrix: MutableList<MutableList<Boolean>>): MutableList<Coordinate> {
    val neighbors: MutableList<Coordinate> = mutableListOf()
    if (i > 0 && !visitedMatrix[i - 1][j]) {
        neighbors.add(Coordinate(i - 1, j))
    }

    if (i < visitedMatrix.size - 1 && !visitedMatrix[i + 1][j]) {
        neighbors.add(Coordinate(i + 1, j))
    }

    if (j > 0 && !visitedMatrix[i][j - 1]) {
        neighbors.add(Coordinate(i, j - 1))
    }

    if (j < visitedMatrix[0].size - 1 && !visitedMatrix[i][j + 1]) {
        neighbors.add(Coordinate(i, j + 1))
    }
    return neighbors
}
