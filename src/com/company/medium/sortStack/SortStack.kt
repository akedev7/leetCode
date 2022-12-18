package com.company.medium.sortStack

import java.util.*

fun main() {
    val stack = Stack<Int>()
    stack.add(-5)
    stack.add(2)
    stack.add(-2)
    stack.add(4)
    stack.add(3)
    stack.add(1)
    val sortStack = getSortStack(stack)

    while (sortStack.isNotEmpty()) {
        println(sortStack.pop())
    }
}

fun getSortStack(stack: Stack<Int>): Stack<Int> {
    sort(stack)
    return stack
}

fun sort(stack: Stack<Int>) {
    if (stack.isEmpty()) {
        return
    }
    val top = stack.pop()
    sort(stack)
    insert(stack, top)
}

fun insert(stack: Stack<Int>, element: Int?) {
    if (stack.empty()) {
        stack.push(element)
    } else {
        if (element!! > stack.peek()) {
            stack.push(element)
        } else {
            val top = stack.pop()
            insert(stack, element)
            stack.push(top)
        }
    }
}
