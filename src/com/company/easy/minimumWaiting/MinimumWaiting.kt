package com.company.easy.minimumWaiting

fun main() {
    val intArrayOf = intArrayOf(3, 2, 1, 2, 6)
    println(getMinimumWaiting(intArrayOf))
}

fun getMinimumWaiting(workSlots: IntArray): Int {
    return workSlots.sorted().mapIndexed { index, i ->
        (i * (workSlots.size - index - 1))
    }.sum()
}
