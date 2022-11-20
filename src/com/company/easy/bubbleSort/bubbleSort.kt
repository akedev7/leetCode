package com.company.easy.bubbleSort

fun main() {
    bubbleSort(mutableListOf(8, 5, 2, 9, 5, 6, 3)).forEach { println(it) }
}

fun bubbleSort(list: MutableList<Int>) : List<Int>{
    var unsorted = true

    while (unsorted) {
        unsorted = false
        var i = 0
        while (i < list.size - 1) {
            if (list[i] > list[i + 1]) {
                val temp = list[i]
                list[i] = list[i + 1]
                list[i + 1] = temp
                unsorted = true
            }
            i++
        }
    }
    return list
}
