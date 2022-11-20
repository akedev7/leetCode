package com.company.easy.nodeDepths

internal class Node(
        var key: Int,
        var left: Node? = null,
        var right: Node? = null)

fun main() {
    val rootNode = Node(10, Node(5, Node(2, Node(1), null), Node(5)), Node(15, Node(13, null, Node(14)), Node(22)))

    println(getSumNodeDepths(rootNode, 0, 0))
}

private fun getSumNodeDepths(node: Node?, sum: Int, depth: Int): Int {
    if (node == null) {
        return 0
    }

    if (node.right == null && node.left == null) {
        return sum + depth
    }
    return getSumNodeDepths(node.left, sum + depth, depth + 1) + getSumNodeDepths(node.right, sum + depth, depth + 1)
}