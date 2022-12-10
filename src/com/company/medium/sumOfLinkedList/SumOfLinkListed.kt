package com.company.medium.sumOfLinkedList

internal class LinkedListNode(val value: Int, var next: LinkedListNode? = null)

fun main() {
    val firstLinkList = LinkedListNode(2, LinkedListNode(4, LinkedListNode(7, LinkedListNode(1))))
    val secondLInkList = LinkedListNode(9, LinkedListNode(4, LinkedListNode(5)))
    getSumOfLinkedLists(firstLinkList, secondLInkList)?.printNode()
}

internal fun getSumOfLinkedLists(firstLinkList: LinkedListNode, secondLInkList: LinkedListNode): LinkedListNode? {
    var sum = getSum(firstLinkList)
    var sum2 = getSum(secondLInkList)
    val totalSum = sum + sum2
    var modCheck = 10
    var prevNode: LinkedListNode? = null
    while (totalSum % modCheck != totalSum) {
        prevNode = getNode(totalSum, modCheck, prevNode)
        modCheck *= 10
    }
    prevNode = getNode(totalSum, modCheck, prevNode)
    return prevNode
}

private fun getNode(totalSum: Int, modCheck: Int, prevNode: LinkedListNode?): LinkedListNode? {
    var prevNode1 = prevNode
    val nodeValue = (totalSum % modCheck) / (modCheck / 10)
    prevNode1 = LinkedListNode(nodeValue, prevNode1)
    return prevNode1
}

private fun getSum(linkList: LinkedListNode): Int {
    var sum = 0
    var multiplier = 1
    var currentNode: LinkedListNode? = linkList
    while (currentNode != null) {
        sum += currentNode.value * multiplier
        multiplier *= 10
        currentNode = currentNode.next
    }
    return sum
}

private fun LinkedListNode.printNode() {
    var currentNode: LinkedListNode? = this
    while (currentNode != null) {
        print("${currentNode.value},")
        currentNode = currentNode.next
    }
    println()
}