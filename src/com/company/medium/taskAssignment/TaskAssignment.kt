package com.company.medium.taskAssignment

fun main() {
    getTaskAssignmentList(listOf(1, 3, 5, 3, 1, 4)).forEach {
        println("Pair ${it.first} - ${it.second}")
    }
}

fun getTaskAssignmentList(inputList: List<Int>): List<Pair<Int, Int>> {
    val durationToIndexMap = getDurationToIndexMap(inputList)
    val sortedList = inputList.sorted()
    val result = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until sortedList.size / 2) {
        val firstIndex = durationToIndexMap[sortedList[i]].pop()
        val secondIndex = durationToIndexMap[sortedList[sortedList.size - i - 1]].pop()
        result.add(firstIndex to secondIndex)
    }
    return result
}

private fun MutableList<Int>?.pop(): Int {
    val number = this?.first()
    this?.removeFirst()
    return number ?: -1
}

typealias Duration = Int
typealias Index = Int
fun getDurationToIndexMap(list: List<Int>): Map<Duration, MutableList<Index>> {
    val map = mutableMapOf<Duration, MutableList<Index>>()
    for (i in list.indices) {
        val mapEntry = map[list[i]]
        if (mapEntry == null) {
            map[list[i]] = mutableListOf(i)
        } else {
            mapEntry.add(i)
        }
    }
    return map
}
