package com.company.medium.minNumberOfCoinsForChange

import kotlin.math.min

fun main() {
    println(getMinOfCoinsForChange(6, setOf(1, 2, 4))) // 2 + 4
    println(getMinOfCoinsForChange(9, setOf(1, 2, 4, 6))) // 6 + 2 + 1
    println(getMinOfCoinsForChange(10, setOf(1, 2, 4, 6))) // 6 + 4
    println(getMinOfCoinsForChange(10, setOf(1, 2))) // 2 + 2 + 2 + 2 + 2
}

typealias NumberOfCoin = Int
fun getMinOfCoinsForChange(targetAmount: Int, coinList: Set<Int>): NumberOfCoin {
    val totalAmountList = MutableList(targetAmount + 1) { 0 }
    coinList.forEach {coinAmount ->
        for ( index in 1 until totalAmountList.size){
            if (coinAmount <= index) {
                   val numberOfCoin = totalAmountList[index - coinAmount] + 1
                if (totalAmountList[index] == 0) {
                    totalAmountList[index] = numberOfCoin
                } else {
                    totalAmountList[index] = min(numberOfCoin, totalAmountList[index])
                }
            }
        }
    }
    return totalAmountList.last()
}
