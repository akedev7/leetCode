package com.company.medium.arrayOfProduct

fun main() {
    getArrayOfProduct(listOf(5, 1, 4, 2)).forEach { println(it) }
}

fun getArrayOfProduct(inputsList: List<Int>): List<Int> {
    val sumOfMultiply = inputsList.reduce { acc, i -> acc * i }
    return inputsList.map { sumOfMultiply / it}
}
