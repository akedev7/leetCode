package com.company.easy.insertionSort

fun main() {
    insertionSort(mutableListOf(8, 5, 2, 9, 5, 6, 3)).forEach { println(it) }
}

fun insertionSort(list: MutableList<Int>): List<Int> {
    for (i in 1 until list.size) {

        var j = i
        while (j > 0 && list[j] < list[j - 1]) {
            val temp = list[j]
            list[j] = list[j - 1]
            list[j - 1 ] = temp
            j--
        }
    }
    return list
}
