package com.company.branchSum

internal class Node(
        var key: Int,
        var left: Node? = null,
        var right: Node? = null)

fun main() {
    val rootNode = Node(10, Node(5, Node(2, Node(1), null), Node(5)), Node(15, Node(13, null, Node(14)), Node(22)))

    val resultList = mutableListOf<Int>()
    getBranchSum(rootNode, 0, resultList)
    resultList.forEach { println(it) }
}

private fun getBranchSum(node: Node?, sum: Int, resultList: MutableList<Int>) {
    if (node == null) {
        return
    }

    if (node.right == null && node.left == null) {
        resultList.add(sum + node.key)
    }

    getBranchSum(node.left, sum + node.key, resultList)
    getBranchSum(node.right, sum + node.key, resultList)
}
