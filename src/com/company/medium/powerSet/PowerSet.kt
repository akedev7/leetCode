package com.company.medium.powerSet



fun main() {
    getPowerSet(listOf(1, 2, 3)).forEach {
        println(it)
    }
}

fun getPowerSet(inputList: List<Int>): List<List<Int>> {
    val subsets = mutableListOf<List<Int>>(listOf())
    for (element in inputList) {
        for (i in 0 until subsets.size) {
            val currentSubSet = subsets[i].toMutableList()
            currentSubSet.add(element)
            subsets.add(currentSubSet)
        }
    }
    return subsets
}
