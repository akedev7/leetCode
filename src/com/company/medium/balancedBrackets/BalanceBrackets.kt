package com.company.medium.balancedBrackets

import java.util.*


fun main() {
    println(isBalancedBrackets("(([]()()){})"))
    println(isBalancedBrackets("(([]()()){}"))
}

val openingBrackets = setOf('[', '(', '{')
val closingBrackets = setOf(']', ')', '}')
val matchingBrackets = mapOf('[' to ']', '(' to ')', '{' to '}')
fun isBalancedBrackets(str: String): Boolean {
    val stack: Stack<Char> = Stack()

    str.forEach {
        if (openingBrackets.contains(it)) {
            stack.push(it)
        } else if (closingBrackets.contains(it)) {
            val element = stack.pop()
            if (matchingBrackets[element] != it) {
                return false
            }
        }
    }
    return stack.isEmpty()
}
