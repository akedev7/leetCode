package com.company.fibonanci

fun main() {
    println(getFibonacci(7))
}

fun getFibonacci(nums: Int): Int {
    if (nums < 0) {
        return 0
    }

    if (nums == 1) {
        return 1
    }

    return getFibonacci(nums - 1) + getFibonacci(nums - 2)
}
