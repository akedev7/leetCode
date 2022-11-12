package com.company.findClosestValueInBst

import kotlin.math.abs

internal class Node(
        var key: Int,
        var left: Node? = null,
        var right: Node? = null)

fun main() {

    // BST (Binary search tree)
    val rootNode = Node(10, Node(5, Node(2, Node(1), null), Node(5)), Node(15, Node(13, null, Node(14)), Node(22)))
    val targetValue = 12
    val closetValue = 65535

    println(findClosetValue(rootNode, targetValue, closetValue))

}

private fun findClosetValue(node: Node?, targetValue: Int, closetValue: Int): Int {

    if (node == null) return closetValue
    val closet: Int = if (abs(targetValue - node.key) < closetValue) {
        node.key
    } else {
        closetValue
    }

    return if (targetValue == node.key) {
        targetValue
    } else if (targetValue > node.key) {
        findClosetValue(node.right, targetValue, closet)
    } else {
        findClosetValue(node.left, targetValue, closet)
    }
}
