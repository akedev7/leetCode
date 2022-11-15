package com.company.productSum


fun main() {
    println(getProductSum(listOf(5, 2, listOf(7, -1), 3, listOf(6, listOf(-13, 8), 4))))
}

fun getProductSum(productList: List<*>, depth: Int = 1): Int {
    return productList.map {
        if (it is Int) {
             it
        } else {
            getProductSum(it as List<*>, depth + 1)
        }
    }.sum() * depth
}
