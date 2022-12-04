package com.company.medium.breathFirstSearch

import java.util.concurrent.ArrayBlockingQueue

data class TreeNode(val value: String, val children: List<TreeNode>? = null)

fun main() {
    val rootNode = TreeNode("A", listOf(TreeNode("B", listOf(TreeNode("E"), TreeNode("F", listOf(TreeNode("I"), TreeNode("J"))))), TreeNode("C"), TreeNode("D", listOf(TreeNode("G", listOf(TreeNode("K"))), TreeNode("H")))))
    println(getBreathFirstSearch(rootNode))
}

//Use Queue
// O( vector + edge) Time - edge coming from when add node to queue
// O(vertex) space
fun getBreathFirstSearch(rootNode: TreeNode): String {
    val resultList: MutableList<String> = mutableListOf()
    val queue = ArrayBlockingQueue<TreeNode>(20)
    queue.add(rootNode)

    while (!queue.isEmpty()) {
        val currentNode = queue.poll()
        resultList.add(currentNode.value)
        currentNode.children?.forEach {
            queue.add(it)
        }
    }
    return resultList.reduce {acc, it -> acc + it}
}
