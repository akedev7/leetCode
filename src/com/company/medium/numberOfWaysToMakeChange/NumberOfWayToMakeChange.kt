package com.company.medium.numberOfWaysToMakeChange

fun main() {
    println(getNumberOfWayToMakeChange(10, setOf(1, 5, 10, 25)))
}

fun getNumberOfWayToMakeChange(targetAmount: Int, coinInputList: Set<Int>): Int {
    val waysForChange = MutableList<Int>(targetAmount + 1) { 0 } // Array of amount 0 to the target amount
    waysForChange[0] = 1 // index represent Total amount e.g., waysForChange[0] means 0 as Total amount, and its value is how many way it can sum up to the total amount. so, for total amount 0, just initialise value as 1
    coinInputList.forEach { coinAmount ->
        waysForChange.forEachIndexed { index, _ ->
            if (coinAmount <= index) {
                waysForChange[index] += waysForChange[index - coinAmount]
            }
        }
    }
    return waysForChange.last()
}
