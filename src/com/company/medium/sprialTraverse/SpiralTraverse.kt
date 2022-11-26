package com.company.medium.sprialTraverse

fun main() {
    getSpiralTraverse(listOf(
            listOf(1, 2 ,3 ,4),
            listOf(12, 13 ,14 ,5),
            listOf(11, 16 ,15 ,6),
            listOf(10, 9 ,8 ,7)
    ), mutableListOf()).forEach { println(it) }

    getSpiralTraverse(listOf(
            listOf(1, 2 ,3 ,4, 5),
            listOf(18, 19 ,20 ,21, 6),
            listOf(17, 28, 29 ,22, 7),
            listOf(16, 27 ,30 ,23, 8),
            listOf(15, 26, 25 ,24 ,9),
            listOf(14, 13, 12 ,11 ,10)
    ), mutableListOf()).forEach { println(it) }
}

fun getSpiralTraverse(listInput: List<List<Int>>, result: MutableList<Int>): MutableList<Int> {
    val width = listInput[0].size - 1
    val height = listInput.size - 1
    for (i in 0 until width) {
        result.add(listInput[0][i])
    }
    for (i in 0 until height) {
        result.add(listInput[i][width])
    }
    for (i in width downTo 1) {
        result.add(listInput[height][i])
    }
    for (i in height downTo 1) {
        result.add(listInput[i][0])
    }

    if (width <= 2 || height <= 2) {
        return mutableListOf()
    }

    val elements = getSpiralTraverse(listInput.subList(1, height).map {it.subList(1, width)}, result)
    result.addAll(elements)
    return result
}
