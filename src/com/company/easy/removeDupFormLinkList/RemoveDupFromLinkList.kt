package com.company.easy.removeDupFormLinkList

data class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}

fun main() {
    val linkList = Node(1, Node(1, Node(3, Node(4, Node(4, Node(4, Node(4, Node(5, Node(5, Node(6, Node(6)))))))))))
    val result = getDeduplicatedLinklist(linkList)

    println(result)
}

fun <T> getDeduplicatedLinklist(node: Node<T>): Node<T> {
    var currentNode = node
    while (currentNode.next != null) {
        if (currentNode.value == currentNode.next?.value) {
            val temp = currentNode.next?.next
            currentNode.next = temp
        } else {
            currentNode = currentNode.next!!
        }
    }
    return node
}
