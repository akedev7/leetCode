package com.company.medium.moveElementToEnd

fun main() {
    moveElementToEnd(mutableListOf(4, 1, 2, 2, 2, 3, 2, 2), 2).forEach { println(it) }

}

fun moveElementToEnd(inputList: MutableList<Int>, target: Int): List<Int> {
    var i: Int = 0
    var j: Int = inputList.size - 1
    while (i < j) {
        if (inputList[j] == target) {
            j--
            continue
        }
        if (inputList[i] == target) {
            val temp = inputList[j]
            inputList[j] = inputList[i]
            inputList[i] = temp
        }
        i++
    }
    return inputList
}
