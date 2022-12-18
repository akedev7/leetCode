package com.company.medium.minMaxStackConstruction

import kotlin.math.max
import kotlin.math.min


typealias Min = Int
typealias Max = Int
class Stack {
    private val stackList: MutableList<Int> = mutableListOf()
    private val minMaxList: MutableList<Pair<Min, Max>> = mutableListOf()

    fun push(value: Int) {
        if (minMaxList.isEmpty()) {
            minMaxList.add(value to value)
        } else {
            val min = min(minMaxList.last().first, value)
            val max = max(minMaxList.last().second, value)
            minMaxList.add(min to max)
        }
        stackList.add(value)
    }

    fun pop(): Int {
        minMaxList.removeLast()
        return stackList.removeLast()
    }

    fun peek(): Int {
        return stackList.last()
    }

    fun getMin(): Int {
        return minMaxList.last().first

    }

    fun getMax(): Int {
       return minMaxList.last().second
    }

}
fun main() {
    val stack = Stack()
    stack.push(5)
    stack.push(2)
    stack.push(7)
    println(stack.getMin())
    println(stack.getMax())
    stack.pop()
    println(stack.getMin())
    println(stack.getMax())
    stack.pop()
    println(stack.getMin())
    println(stack.getMax())

}