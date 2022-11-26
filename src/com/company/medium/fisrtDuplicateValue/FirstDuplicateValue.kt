package com.company.medium.fisrtDuplicateValue

fun main() {
    println(getFirstDuplicateValue(listOf(2, 1, 5, 3, 3, 2, 4)))
    println(getFirstDuplicateValue(listOf(2, 1, 5, 2, 3, 3, 4)))
}
// O(n) Time
// O(n) Space (Set space of n)
fun getFirstDuplicateValue(inputList: List<Int>): Int {
    val set = mutableSetOf<Int>()
    inputList.forEach {
        if (set.contains(it)) {
            return it
        }
        set.add(it)
    }
    return -1
}
