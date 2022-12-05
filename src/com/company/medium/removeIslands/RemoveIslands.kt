package com.company.medium.removeIslands

import java.util.*

fun main() {
    removeIslands(
            mutableListOf(
                    mutableListOf(1, 0, 0, 0, 0, 0),
                    mutableListOf(0, 1, 0, 1, 1, 1),
                    mutableListOf(0, 0, 1, 0, 1, 0),
                    mutableListOf(1, 1, 0, 0, 1, 0),
                    mutableListOf(1, 0, 1, 1, 0, 0),
                    mutableListOf(1, 0, 0, 0, 0, 1),
            )).forEach {
        it.forEach {
            print(it)
        }
        println()
    }
}

private fun removeIslands(matrix: MutableList<MutableList<Int>>): List<List<Int>> {
    val visitedMatrix = MutableList(matrix.size) { MutableList(matrix[0].size) { false } }
    for (row in matrix.indices) {
        for (col in matrix[0].indices) {
            if (visitedMatrix[row][col]) {
                continue
            }
            traverseGraph(row, col, matrix, visitedMatrix)
        }
    }
    return matrix
}

typealias Coordinate = Pair<Int, Int>

fun traverseGraph(row: Int, col: Int, matrix: MutableList<MutableList<Int>>, visitedMatrix: MutableList<MutableList<Boolean>>) {
    var isConnectedToBorder = false
    val coordinateToRemove: MutableList<Coordinate> = mutableListOf()
    val stack = Stack<Coordinate>()
    stack.add(Coordinate(row, col))
    while (!stack.isEmpty()) {
        val coordinate = stack.pop()
        if (visitedMatrix[coordinate.first][coordinate.second]) {
            continue
        }
        visitedMatrix[coordinate.first][coordinate.second] = true
        if (matrix[coordinate.first][coordinate.second] == 0) {
            continue
        }

        if (isConnectedToBorder(coordinate, matrix)) {
            isConnectedToBorder = true
        }

        coordinateToRemove.add(coordinate)
        val neighborsNodes = getNeighborsNodes(coordinate.first, coordinate.second, visitedMatrix)
        neighborsNodes.forEach {
            stack.add(it)
        }
    }
    if (!isConnectedToBorder) {
        coordinateToRemove.forEach {
            matrix[it.first][it.second] = 0
        }
    }
}

private fun isConnectedToBorder(coordinate: Coordinate, matrix: MutableList<MutableList<Int>>) =
        coordinate.first == 0 || coordinate.first == matrix.size - 1 || coordinate.second == 0 || coordinate.second == matrix[0].size - 1

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
