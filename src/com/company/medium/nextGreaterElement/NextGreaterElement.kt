package com.company.medium.nextGreaterElement

import java.util.*

fun main() {
    getNextGreaterElement(listOf(2, 5, -3, -4, 6, 7, 2)).forEach {
        println(it)
    }
}
// O(N) time
// O(n) space
fun getNextGreaterElement(inputList: List<Int>): List<Int> {

    val resultList: MutableList<Int> = MutableList(inputList.size) { -1 }
    val stack = Stack<Int>()

    // Loop twice because it's circular list
    // Use stack to accumulate all the element until it reach the number which is greater than the one on the top of the stack
    for (i in 0 until (inputList.size * 2)) {
        val position = i % inputList.size
        if (stack.isEmpty()) {
            stack.push(position)
        } else {
            while (stack.isNotEmpty() && inputList[position] > inputList[stack.peek()]) {
                val pop = stack.pop()
                resultList[pop] = inputList[position]
            }
            stack.push(position)
        }
    }
    return resultList
}
