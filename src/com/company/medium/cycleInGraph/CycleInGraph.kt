package com.company.medium.cycleInGraph

fun main() {
    println(hasCycleInGraph(listOf(
            listOf(1, 3),
            listOf(2, 3, 4),
            listOf(0),
            listOf(),
            listOf(2, 5),
            listOf()
    )))

    println(hasCycleInGraph(listOf(
            listOf(1, 3),
            listOf(2, 3, 4),
            listOf(),
            listOf(),
            listOf(2, 5),
            listOf()
    )))
}

fun hasCycleInGraph(graph: List<List<Int>>): Boolean {
    val visited = MutableList(graph.size) { false }
    val currentlyInStack = MutableList(graph.size) { false }
    for (node in graph.indices) {
        if (visited[node]) {
            continue
        }
        // cannot use stack instead of recursive because need to keep track of the call stack
        // cannot just return isCycleInGraph method because if it's false, it will just return false, so it will not continue all the node
        if (isCycleInGraph(node, graph, visited, currentlyInStack)) {
            return true
        }
    }
    return false
}

fun isCycleInGraph(node: Int, graph: List<List<Int>>, visited: MutableList<Boolean>, currentlyInStack: MutableList<Boolean>): Boolean {
    visited[node] = true
    val neighbors = graph[node]
    neighbors.forEach {
        if (!visited[it]) {
            //cannot just return isCycleInGraph method because if it's false, it will just return false, so it will not continue all the node
            if (isCycleInGraph(it, graph, visited, currentlyInStack)) {
                return true
            }
        } else if (currentlyInStack[it]) {
            return true
        }
    }
    return false
}
