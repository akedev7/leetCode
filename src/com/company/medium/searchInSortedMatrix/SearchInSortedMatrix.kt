package com.company.medium.searchInSortedMatrix

fun main() {
    println(getSearchInSortedMatrix(
            listOf(
                    listOf(1, 4, 7, 12, 15, 1000),
                    listOf(2, 5, 19, 31, 32, 1001),
                    listOf(3, 8, 24, 33, 35, 1002),
                    listOf(40, 41, 42, 44, 45, 1003),
                    listOf(99, 100, 103, 106, 128, 1004),
            ), 44

    ))
}

// O( N + M ) space where N is row and M is column
// The logic is start on the right top conor and eliminate entire row if it's smaller than the target and eliminate entire column if it's grater than the target.
fun getSearchInSortedMatrix(matrix: List<List<Int>>, targetNumber: Int): Pair<Int, Int> {
    var row = 0
    var col = matrix[0].size - 1

    while (row < matrix.size && col >= 0) {
        if (matrix[row][col] > targetNumber) {
            col--
        } else if (matrix[row][col] < targetNumber) {
            row++
        } else {
            return Pair(row, col)
        }
    }
    return Pair(-1, -1)
}
